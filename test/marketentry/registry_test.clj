(ns marketentry.registry-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.registry :as registry]))

(deftest engagement-fee-recompute
  (let [e {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 860000.0}]
    (is (== 860000.0 (registry/compute-engagement-fee e)))
    (is (true? (registry/engagement-fee-matches-claim? e))))
  (let [bad {:base-fee 500000 :monthly-rate 30000 :monitoring-months 12 :claimed-fee 999000.0}]
    (is (false? (registry/engagement-fee-matches-claim? bad)))))

(deftest register-draft-and-submit
  (let [d (registry/register-draft "eng-1" "SLE" 0)
        s (registry/register-submit "eng-1" "SLE" 0)]
    (is (= "SLE-DFT-000000" (get d "draft_number")))
    (is (= "SLE-SUB-000000" (get s "submit_number")))
    (is (nil? (get-in d ["certificate" "proof"])))
    (is (= "draft-unsigned" (get-in s ["certificate" "status"])))))

(deftest register-requires-ids
  (is (thrown? Exception (registry/register-draft "" "SLE" 0)))
  (is (thrown? Exception (registry/register-submit "eng-1" "" 0))))

(deftest margin-of-preference-percentage-band
  (testing "Regulation 75(3)'s own 5-12 percent statutory band"
    (is (true? (registry/margin-of-preference-percentage-in-band? 5)))
    (is (true? (registry/margin-of-preference-percentage-in-band? 12)))
    (is (true? (registry/margin-of-preference-percentage-in-band? 8)))
    (is (false? (registry/margin-of-preference-percentage-in-band? 4.9)))
    (is (false? (registry/margin-of-preference-percentage-in-band? 12.1)))
    (is (false? (registry/margin-of-preference-percentage-in-band? nil)))))

(deftest margin-of-preference-ground-recognition
  (testing "Regulation 75(2)(a)'s own named eligibility categories"
    (is (true? (registry/margin-of-preference-ground-recognized? :ownership)))
    (is (true? (registry/margin-of-preference-ground-recognized? :origin-of-labour)))
    (is (true? (registry/margin-of-preference-ground-recognized? :origin-of-raw-material-or-components)))
    (is (false? (registry/margin-of-preference-ground-recognized? :other-relevant-factor)))
    (is (false? (registry/margin-of-preference-ground-recognized? nil))
        "the Regulation's own 'or any other relevant factor' is NOT auto-recognized without a circular this iteration could not fetch")))

(deftest margin-of-preference-eligible-requires-both-axes
  (testing "both the percentage band AND the eligibility ground must independently pass"
    (is (true? (registry/margin-of-preference-eligible?
                {:margin-of-preference-pct 10 :margin-of-preference-eligibility-ground :ownership})))
    (is (false? (registry/margin-of-preference-eligible?
                 {:margin-of-preference-pct 15 :margin-of-preference-eligibility-ground :ownership}))
        "pct exceeds the 12 percent ceiling")
    (is (false? (registry/margin-of-preference-eligible?
                 {:margin-of-preference-pct 10 :margin-of-preference-eligibility-ground :unrecognized-factor}))
        "ground is not one of the Regulation's own named categories")
    (is (false? (registry/margin-of-preference-eligible?
                 {:margin-of-preference-pct nil :margin-of-preference-eligibility-ground nil})))))

(deftest margin-of-preference-invalid-claim-is-entity-scope-gated
  (testing "an engagement that does not claim the margin of preference is never flagged"
    (is (false? (registry/margin-of-preference-invalid-claim?
                 {:claims-margin-of-preference? false
                  :margin-of-preference-pct 99 :margin-of-preference-eligibility-ground :bogus}))))
  (testing "a claiming engagement whose declared percentage exceeds Regulation 75(3)'s own ceiling is flagged"
    (is (true? (registry/margin-of-preference-invalid-claim?
                {:claims-margin-of-preference? true
                 :margin-of-preference-pct 15 :margin-of-preference-eligibility-ground :ownership}))))
  (testing "a claiming engagement whose declared ground is not Regulation 75(2)(a)'s own named category is flagged"
    (is (true? (registry/margin-of-preference-invalid-claim?
                {:claims-margin-of-preference? true
                 :margin-of-preference-pct 8 :margin-of-preference-eligibility-ground :brand-loyalty}))))
  (testing "a claiming engagement that clears BOTH axes is not flagged"
    (is (false? (registry/margin-of-preference-invalid-claim?
                 {:claims-margin-of-preference? true
                  :margin-of-preference-pct 8
                  :margin-of-preference-eligibility-ground :extent-of-subcontracting-or-association-with-local-partners})))))
