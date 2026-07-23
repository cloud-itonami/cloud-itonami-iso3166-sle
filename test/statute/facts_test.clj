(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest sle-has-spec-basis
  (let [sb (facts/spec-basis "SLE")]
    (is (= 4 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "http") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["SLE" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["sle.employment-act-2023"]
         (mapv :statute/id (facts/by-topic "SLE" :labor))))
  (is (= ["sle.income-tax-act-2000"]
         (mapv :statute/id (facts/by-topic "SLE" :tax))))
  (is (= ["sle.companies-act-2009"]
         (mapv :statute/id (facts/by-topic "SLE" :corporate-governance))))
  (is (= ["sle.national-investment-board-act-2022"]
         (mapv :statute/id (facts/by-topic "SLE" :investment))))
  (is (empty? (facts/by-topic "ATL" :labor))))
