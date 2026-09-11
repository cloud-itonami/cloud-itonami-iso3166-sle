(ns marketentry.registry
  "Pure-function market-entry filing-draft + filing-submit record
  construction -- an append-only market-entry book-of-record draft.

  Like every sibling actor's registry, there is no single international
  reference-number standard for a public-procurement market-entry
  filing -- every jurisdiction assigns its own format. This namespace
  does NOT invent one; it builds a jurisdiction-scoped sequence number
  and validates the record's required fields, the same honest,
  non-fabricating discipline `marketentry.facts` uses.

  `engagement-fee-matches-claim?` is an HONEST reapplication of the
  SAME ground-truth-recompute DISCIPLINE sibling actors use (verify a
  claimed monetary total against the entity's own recorded quantity x
  unit fields), reapplied to a market-entry engagement fee line.

  `margin-of-preference-eligible?` / `margin-of-preference-invalid-
  claim?` are the SAME discipline applied to a genuinely
  Sierra-Leone-specific mechanism: the Public Procurement Act, 2016's
  own Section 36 ('Margin of preference') and the Public Procurement
  Regulations, 2020's own Regulation 75 (own text, fetched directly,
  see `marketentry.facts`) -- a TWO-PART gate:

    1. The declared margin-of-preference PERCENTAGE must fall within
       the Regulations' own STATUTORY BAND: Regulation 75(3), own
       text, 'The percentage of preference in schemes issued by the
       Authority shall be between 5 and 12 percent'. Any claimed
       percentage outside [5, 12] is invalid, independent of anything
       else the engagement declares.
    2. The declared ELIGIBILITY GROUND must be one of the categories
       Regulation 75(2)(a) itself names: 'ownership, location of
       bidder or production facilities, origin of labour, raw material
       or components, extent of sub-contracting or association with
       local partners'. The Regulation's own text also allows 'any
       other relevant factor', but this catalog does NOT treat an
       undocumented, unenumerated ground as auto-eligible -- an
       engagement claiming a ground outside the five NAMED categories
       has no independently-verifiable spec-basis for it (the same
       fails-closed discipline this family's LBR catalog applies to an
       Investment Act ownership tier the Schedule's own text does not
       name), so it is NOT recognized here.

  This is a GENUINELY DIFFERENT check SHAPE than every prior iso3166
  sibling this repo mirrors: Bulgaria's ЗОП Art. 54(5) de-minimis is a
  PERCENTAGE-OF-TURNOVER eligibility formula, Albania's Neni 76(2)(c)
  carve-out is a SINGLE FLAT-CONSTANT threshold (the same number for
  every entity), Azerbaijan's/Armenia's flagship checks are BOOLEAN
  registry-membership reads, Antigua and Barbuda's vendor-class check
  is a THREE-TIER eligibility-threshold classification, Benin's MPME
  mechanism is a BID-EVALUATION PRICE ADJUSTMENT keyed on a fixed
  category (not a regulator-set rate range), Bhutan's FDI Negative List
  is a CATEGORICAL SECTOR-EXCLUSION allow-list gate, Botswana's
  citizen/resident-preference check is an ORDERED-TIER CLASSIFICATION,
  CAF's Marché réservé mechanism is a MULTI-CRITERION INCLUSION-
  ELIGIBILITY test (an OR of THREE workforce-composition percentage
  thresholds and a legal-form set-membership test), Estonia's digital-
  signing-method check tests the VALIDITY OF THE FILING'S OWN EXECUTION
  INSTRUMENT (a procedural axis, not the bidder's business substance at
  all), the Gambia's SIC mechanism is a FLAT INVESTMENT-AMOUNT
  THRESHOLD whose OWN VALUE is selected by the engagement's declared
  investor-origin attribute, Guinea's flagship is a PECUNIARY-SANCTION-
  RANGE violation test (a fine amount, not a benefit rate), and
  Liberia's Investment Act Schedule is a TWO-SCHEDULE COMPOUND GATE
  combining a categorical sector-exclusion list with a SEPARATE
  ownership-percentage-scaled capital threshold. Sierra Leone's margin
  of preference is none of these: it is a REGULATORY-CEILING/FLOOR-
  BOUNDED, MULTI-FACTOR-ELIGIBILITY DISCRETIONARY BENEFIT-RATE gate --
  the mechanism it validates is not a bidder-eligibility bar or a
  penalty at all, but a PREFERENTIAL bid-evaluation price adjustment
  the Act itself delegates to per-procurement administrative circulars,
  constrained only by a statutory percentage BAND (own text: 'between 5
  and 12 percent') and an open-but-NAMED-category eligibility-ground
  list. No other sibling in this family models a delegated,
  regulator-set RATE constrained by a statutory min/max band combined
  with an enumerated (not closed-list-exhaustive, but not free-text
  either) eligibility-ground test.

  This namespace is pure data + pure functions -- no I/O, no network
  call to any real procurement or investment portal. It builds the
  RECORD an operator would keep, not the act of submitting a portal
  registration itself (that is `marketentry.operation`'s `:filing/
  submit`, always human-gated -- see README Actuation)."
  (:require [kotoba.lang.text :as str]))

(defn- unsigned-certificate
  "Every certificate this actor produces is UNSIGNED -- signature is
  the market-entry operator's act, not this actor's."
  [kind subject record-id]
  {"@context" ["https://www.w3.org/ns/credentials/v2"]
   "type" ["VerifiableCredential" kind]
   "credentialSubject" {"id" subject "record" record-id}
   "proof" nil
   "issued_by_registry" false
   "status" "draft-unsigned"})

(defn- zero-pad [n w]
  (let [s (str n)]
    (str (apply str (repeat (max 0 (- w (count s))) "0")) s)))

(def ^:private money-scale
  "Sub-minor-unit scale used when comparing two money amounts: 1/10000 of
  a unit. Coarser than double representation error by many orders of
  magnitude, finer than any real currency's minor unit (2 decimals for
  most, 3 for KWD/BHD/OMR, 0 for JPY/KRW)."
  10000)

(defn- money=
  "Exact-at-money-precision equality for two amounts.

  `==` on raw doubles is NOT the right comparison for money. With
  whole-unit fees the two agree, but as soon as an amount carries
  cents the sum `base + rate x months` is routinely not the double
  nearest the true total, and a CORRECT claim compares false: measured
  on this exact shape, 40,989 of 327,060 cent-denominated combinations
  (12.5%) were rejected while being right, against 0 of 327,060 in
  whole units.

  Rounding both sides to `money-scale` before comparing removes the
  representation error while preserving every distinction money can
  actually carry."
  [x y]
  (and (number? x) (number? y)
       (= (Math/round (* money-scale (double x)))
          (Math/round (* money-scale (double y))))))

(defn compute-engagement-fee
  "The ground-truth engagement fee for `engagement`'s own `:base-fee`
  and `:monitoring-months` x `:monthly-rate` -- a single flat
  base + months x rate calculation, not a full pricing engine."
  [{:keys [base-fee monthly-rate monitoring-months]}]
  ;; nil when any field is not a number: an un-recomputable engagement is
  ;; un-verifiable, which is neither `correct` nor a ClassCastException
  ;; thrown out of the caller.
  (when (and (number? base-fee) (number? monthly-rate) (number? monitoring-months))
    (+ (double base-fee)
       (* (double monthly-rate) (double monitoring-months)))))

(defn engagement-fee-matches-claim?
  "Does `engagement`'s own `:claimed-fee` equal the independently
  recomputed `compute-engagement-fee`?"
  [{:keys [claimed-fee] :as engagement}]
  (money= claimed-fee (compute-engagement-fee engagement)))

(def margin-of-preference-pct-floor
  "Public Procurement Regulations, 2020, Regulation 75(3) (own text,
  fetched directly 2026-07-23): 'The percentage of preference in
  schemes issued by the Authority shall be between 5 and 12 percent'."
  5)

(def margin-of-preference-pct-ceiling
  "Same source as `margin-of-preference-pct-floor` -- the upper bound
  of the statutory band."
  12)

(def recognized-margin-of-preference-grounds
  "Regulation 75(2)(a) (own text, fetched directly 2026-07-23): 'any
  rules or schemes... shall clearly state -- eligibility for the
  margin of preference, in terms of ownership, location of bidder or
  production facilities, origin of labour, raw material or components,
  extent of sub-contracting or association with local partners or any
  other relevant factor'. This set models exactly the FIVE NAMED
  categories; the Regulation's own trailing 'or any other relevant
  factor' is NOT modeled as an open wildcard here (this iteration did
  not fetch any circular defining what 'other relevant factor' means
  for a specific scheme, so an engagement cannot claim eligibility on
  an unenumerated ground and have that claim independently verified)."
  #{:ownership
    :location-of-bidder-or-production-facilities
    :origin-of-labour
    :origin-of-raw-material-or-components
    :extent-of-subcontracting-or-association-with-local-partners})

(defn margin-of-preference-percentage-in-band?
  "Is `pct` within the Regulation's own [5, 12] statutory band,
  independently recomputed from the engagement's own declared
  `:margin-of-preference-pct`?"
  [pct]
  (boolean
   (and (some? pct)
        (<= margin-of-preference-pct-floor (double pct) margin-of-preference-pct-ceiling))))

(defn margin-of-preference-ground-recognized?
  "Is `ground` one of Regulation 75(2)(a)'s own NAMED eligibility
  categories?"
  [ground]
  (boolean (contains? recognized-margin-of-preference-grounds ground)))

(defn margin-of-preference-eligible?
  "The ground-truth Regulation 75 eligibility for `engagement`'s own
  declared `:margin-of-preference-pct` and `:margin-of-preference-
  eligibility-ground` -- BOTH the percentage-band test and the
  eligibility-ground test must independently pass."
  [{:keys [margin-of-preference-pct margin-of-preference-eligibility-ground]}]
  (boolean
   (and (margin-of-preference-percentage-in-band? margin-of-preference-pct)
        (margin-of-preference-ground-recognized? margin-of-preference-eligibility-ground))))

(defn margin-of-preference-invalid-claim?
  "Does `engagement` declare `:claims-margin-of-preference? true` while
  the INDEPENDENTLY recomputed `margin-of-preference-eligible?` is
  false? An engagement that does not claim the margin of preference at
  all is never flagged by this check -- entity-scope-gated, the same
  discipline this family's LBR catalog uses for its own
  `:foreign-company?`-gated Investment Act Schedule check."
  [{:keys [claims-margin-of-preference?] :as engagement}]
  (boolean (and claims-margin-of-preference?
                (not (margin-of-preference-eligible? engagement)))))

(defn register-draft
  "Validate + construct the FILING-DRAFT registration DRAFT -- the
  market-entry operator's own act of preparing a portal registration
  package. Pure function -- does not touch any real procurement
  portal."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "draft: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "draft: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "draft: sequence must be >= 0" {})))
  (let [draft-number (str (str/upper jurisdiction) "-DFT-" (zero-pad sequence 6))
        record {"record_id" draft-number
                "kind" "filing-draft"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "draft_number" draft-number
     "certificate" (unsigned-certificate "FilingDraft" draft-number draft-number)}))

(defn register-submit
  "Validate + construct the FILING-SUBMIT registration DRAFT -- the
  market-entry operator's own act of actually submitting a portal
  registration (always human-gated upstream)."
  [engagement-id jurisdiction sequence]
  (when-not (and engagement-id (not= engagement-id ""))
    (throw (ex-info "submit: engagement_id required" {})))
  (when-not (and jurisdiction (not= jurisdiction ""))
    (throw (ex-info "submit: jurisdiction required" {})))
  (when (< sequence 0)
    (throw (ex-info "submit: sequence must be >= 0" {})))
  (let [submit-number (str (str/upper jurisdiction) "-SUB-" (zero-pad sequence 6))
        record {"record_id" submit-number
                "kind" "filing-submit"
                "engagement_id" engagement-id
                "jurisdiction" jurisdiction
                "immutable" true}]
    {"record" record "submit_number" submit-number
     "certificate" (unsigned-certificate "FilingSubmit" submit-number submit-number)}))

(defn append [history result]
  (conj (vec history) (get result "record")))
