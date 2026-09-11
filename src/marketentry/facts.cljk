(ns marketentry.facts
  "Per-jurisdiction public-procurement market-entry regulatory catalog
  -- the G2-style spec-basis table the Market-Entry Compliance Governor
  checks every `:jurisdiction/assess` proposal against ('did the advisor
  cite an OFFICIAL public source for this jurisdiction's requirements,
  or did it invent one?').

  Sierra Leone's real market-entry surface (curl/WebFetch-verified
  2026-07-23; where a page could not be reached, or a document could
  not be independently confirmed, that is stated explicitly rather than
  silently omitted). Sierra Leone is a common-law jurisdiction (like
  Liberia and unlike its Francophone OHADA neighbors) -- its own
  statutes (Public Procurement Act, Companies Act, National Investment
  Board Act) are cited directly below, not a supranational Uniform Act.

  - **Public procurement** is regulated by the National Public
    Procurement Authority (NPPA, `nppa.gov.sl`, fetched directly --
    ordinary server-rendered WordPress site with full content). NPPA's
    own 'Acts & Regulations' page (`nppa.gov.sl/acts-and-regulations/`,
    fetched directly) lists, and this iteration downloaded and read the
    ACTUAL PDF text of, both governing instruments hosted on NPPA's own
    site: 'The Public Procurement Act 2016' (own text, cover page:
    'Supplement to the Sierra Leone Gazette Vol. CXLVII, No. 10 dated
    25th February, 2016 ... THE PUBLIC PROCUREMENT ACT, 2016 ... No. 1
    2016 ... Signed this 11th day of February, 2016. DR. ERNEST BAI
    KOROMA, President.'; own Section 69(1): 'The Public Procurement Act,
    2004 is hereby repealed') and 'Public Procurement Regulation 2020'
    (own text, cover page: 'STATUTORY INSTRUMENT No. 5 of 2020 ...
    Published 19th March, 2020 ... THE PUBLIC PROCUREMENT REGULATIONS,
    2020 ... In exercise of the powers conferred on the Authority by
    Section 68 of the Public Procurement Act, 2016, the Authority hereby
    makes the following Regulations'). This iteration read the Act's
    Section 3 (continuance of NPPA), Section 14 (functions), Section 21
    (qualification of bidders, ten criteria (a)-(j) INCLUDING '(i)
    assessment by the National Revenue Authority to ascertain payment of
    taxes; and (j) payment of social security contributions', own text,
    and its own subsection (2): 'not by using a point system for
    comparing the relative level of qualifications of participating
    bidders'), Section 35 (debarment, one-to-six-year range gated on
    eight enumerated grounds (a)-(h)), Section 36 (margin of preference,
    grounds the flagship check below) and the First Schedule (Le
    threshold table for RFQ/NCB/ICB by goods/works/services, and a
    separate three-tier contract-award approval-authority table). This
    iteration deliberately did NOT build a governor check on Section 35
    debarment (a range-gated-on-enumerated-grounds sanction shape this
    family's GIN catalog's `:pecuniary-sanction-range-violated` check
    already occupies, and the fleet-wide 'debarment-lifecycle' shape
    this task's own review flagged as already existing) nor on the First
    Schedule's threshold table (a bidding-method/approval-tier lookup
    this family's `:procedure-eligibility-gate` shape already occupies)
    -- both are real, both are documented here for completeness, neither
    is this vertical's flagship.
  - **Business/company registration** is handled by the Corporate
    Affairs Commission (CAC). This iteration independently confirmed
    CAC's role from TWO separate official sources that do not copy from
    each other: (1) the Companies Act, 2009's OWN primary text (Act No.
    5 of 2009, Sierra Leone Gazette Vol. CXL, No. 36, dated 13th August
    2009; hosted on `sierra-leone.org`'s long-running Sierra Leone laws
    archive, fetched directly, own Table of Contents: 'PART II -
    CORPORATE AFFAIRS COMMISSION -- 2. Establishment of Corporate
    Affairs Commission. 3. Membership of Commission. ... 9. Appointment
    of Registrar.'), and (2) the Sierra Leone Investment and Export
    Promotion Agency's (SLIEPA, `sliepa.gov.sl`, fetched directly) own
    'Starting a Business' page, which names CAC directly ('Download and
    complete documents required to incorporate your business found on
    Sierra Leone's Corporate Affairs Commission website'), states
    registration 'is free of charge', and gives CAC's own registration
    email (`register@cac.gov.sl`) and head-office address ('15 Syke
    Street, Freetown'). HOWEVER: `cac.gov.sl` itself did not resolve
    (DNS `ENOTFOUND`) for this iteration -- an honestly-flagged ACCESS
    gap on CAC's own domain, not a claim CAC does not exist (the same
    discipline this family's LBR catalog used for `www.lbr.gov.lr`'s
    connection timeout). SLIEPA itself is mid-transition: its own
    homepage carries a banner stating it is 'currently transitioning to
    become the National Investment Board (NIB)', and the National
    Investment Board Act, 2022's own Section 52(1) (`sierralii.gov.sl`,
    Sierra Leone's Legal Information Institute, fetched directly)
    repeals both '(a) The Investment Promotion Act 2004; (b) The Sierra
    Leone Investment and Export Promotion Agency [Act] 2007' -- this
    iteration cross-confirmed this repeal directly rather than assuming
    it from the transition banner alone.
  - **Tax/TIN registration** is administered by the National Revenue
    Authority (NRA). NPPA's own hosted PDF names the current governing
    instrument as 'The NRA Act 2002', and this iteration independently
    corroborated its existence and number from the SEPARATE
    `sierra-leone.org` archive: 'The National Revenue Authority Act,
    2002 [No. 11 of 2002]'. SierraLII separately lists a 'National
    Revenue Authority Act, 2022 (Act 21 of 2022)' -- this iteration
    found this listing but could NOT fetch or read its primary text
    (the fetch returned only page-shell metadata, not readable statutory
    content), so it does NOT claim whether or how the 2022 entry amends,
    consolidates or replaces the 2002 Act; this is an honest, undecided
    gap, not a claim either way. Separately, this iteration downloaded
    and read the NRA's own cover page for 'THE CONSOLIDATED Income Tax
    Act, 2000 ... Updated to reflect all tax legislation through
    December 31, 2008 ... June 2009' (own NRA branding/logo, hosted via
    the same `sierra-leone.org` archive) -- the substantive tax code the
    NRA administers, separate from the NRA Act itself which only
    establishes the collecting authority.
  - `margin-of-preference-spec-basis` grounds this vertical's FLAGSHIP
    check (see `marketentry.governor` / `marketentry.registry`) -- a
    genuinely Sierra-Leone-specific mechanism this iteration found
    directly in the Public Procurement Act 2016's OWN Section 36 and
    the Public Procurement Regulations 2020's OWN Regulation 75 (both
    read as primary PDF text, not paraphrased). Section 36 ('Margin of
    preference'), own text: '(1) A procuring entity may grant a margin
    of preference for the benefit of bids for work by domestic
    contractors or for the benefit of bids for domestically produced
    goods or for the benefit of domestic suppliers of services. (2) The
    margin of preference shall be calculated in accordance with the
    regulations and reflected in the record of the procurement
    processes. (3) The margin of preference shall be authorised by the
    Authority and shall be subject to approval by the Authority.'
    Regulation 75 ('Margin of preference'), own text: '(1) Where so
    indicated in the bidding document, and in accordance with any rules
    or schemes for margin of preference issued by the Authority through
    circulars, the evaluators shall apply a margin of preference to
    eligible bids. (2) Any rules or schemes issued by the Authority
    through circulars and the bidding documents, shall clearly state -
    (a) eligibility for the margin of preference, in terms of ownership,
    location of bidder or production facilities, origin of labour, raw
    material or components, extent of sub-contracting or association
    with local partners or any other relevant factor; (b) the
    documentation required as evidence of eligibility for the margin of
    preference; and (c) the percentage of the margin of preference and
    the manner in which it will be applied during the evaluation. (3)
    The percentage of preference in schemes issued by the Authority
    shall be BETWEEN 5 AND 12 PERCENT and the Authority may review these
    percentages periodically.' This iteration did NOT independently
    fetch any actual NPPA circular implementing a specific margin-of-
    preference scheme for a specific procurement -- the Regulation's
    own text delegates the exact per-procurement percentage and
    eligibility documentation to circulars this iteration was not able
    to locate, an honest, delegated-to-circular gap (the same discipline
    this family's LBR catalog used for the Investment Act's own
    delegated bidding-value thresholds, and CAF's own ministerial-
    arrêté-delegated value threshold). What Regulation 75(3) DOES state
    directly, in its own primary text with no delegation, is the
    statutory CEILING/FLOOR band (5-12%) any such circular's percentage
    must fall within, and Regulation 75(2)(a) DOES name, in its own
    primary text, the categories of eligibility factor a scheme may be
    grounded in (ownership / location of bidder or production
    facilities / origin of labour / origin of raw material or
    components / extent of sub-contracting or association with local
    partners) -- this catalog models exactly these two directly-stated
    constraints, not the undocumented specific circulars.
  - This iteration also confirmed the National Investment Board Act,
    2022 (Act No. 11 of 2022, `sierralii.gov.sl`, own text: 'Being an
    Act to establish an investment board to promote investment
    opportunities...') as Sierra Leone's current investment-promotion
    statute. Its own Section 7(1)(p) empowers the Board to 'make and
    implement policies to reserve sections and areas of investment for
    Sierra Leoneans to promote local content', and its own Section
    31(2)(a)/(b) conditions certain incentives on 'the minimum
    investment threshold for the investment set by the Board' and
    'engaging in any of the priority areas set out by the Board' --
    UNLIKE Liberia's Investment Act of 2010, whose own Schedule
    enumerates its reserved-sector list and capital thresholds directly
    in the Act's own text, Sierra Leone's National Investment Board Act
    delegates BOTH the reserved-sector list and the investment
    threshold to Board policy/guidelines this iteration was not able to
    locate or fetch. This is a real, current, corroborated mechanism
    (its own Section 2 also directly excludes narcotics and
    military/police/customs/immigration-wear investment, and its own
    Section 52(1) confirms it repealed both the Investment Promotion Act
    2004 and the SLIEPA Act 2007) -- but because its substantive
    restrictions are wholly delegated rather than enumerated in the Act
    itself, this iteration deliberately does NOT build a Liberia-style
    two-schedule sector-exclusion governor check on it (that would
    require fabricating a sector list the Act itself does not state);
    it is documented here as an honestly-narrowed adjacent mechanism
    this iteration chose NOT to build a check on, the same discipline
    this family's LBR catalog used for the Gambia-style GIEPA SIC shape
    it found but declined to model.

  Coverage is reported HONESTLY (see `coverage`): a jurisdiction not in
  this table has NO spec-basis, full stop -- the advisor must not
  fabricate one, and the governor holds if it tries.")

(def catalog
  "iso3 -> requirement map. `:required-evidence` mirrors the generic
  intake/portal-registration/filing evidence set; `:legal-basis` /
  `:owner-authority` / `:provenance` are the G2 citation the governor
  requires before any `:jurisdiction/assess` proposal can commit. SLE
  deliberately carries NO `:rep-owner-authority` -- this iteration did
  not find a Sierra-Leone-specific representative/director exclusion-
  extension provision in any primary text it was actually able to
  read (an honest gap, not a claim none exists). `:margin-of-
  preference-*` grounds this vertical's flagship governor check
  (`margin-of-preference-eligible?`/`margin-of-preference-invalid-
  claim?` in `marketentry.registry`)."
  {"SLE" {:name "Sierra Leone"
          :owner-authority "National Public Procurement Authority (NPPA) -- continued in existence by 'The Public Procurement Act, 2016', own text: Section 3(1) 'there is hereby continued in existence... the body which... was known as the National Public Procurement Authority' (nppa.gov.sl, own hosted PDF, fetched directly)"
          :legal-basis "The Public Procurement Act, 2016 (Act No. 1 of 2016, Sierra Leone Gazette Vol. CXLVII No. 10, dated 25th February 2016; own text: 'Signed this 11th day of February, 2016. DR. ERNEST BAI KOROMA, President.'; own Section 69(1) repeals the Public Procurement Act, 2004, Act No. 14 of 2004) + The Public Procurement Regulations, 2020 (Statutory Instrument No. 5 of 2020, published 19th March 2020, made by NPPA under Section 68 of the Act) -- both fetched and read directly as primary PDF text from nppa.gov.sl"
          :national-spec "Business/company registration: Corporate Affairs Commission (CAC) under the Companies Act, 2009 (Act No. 5 of 2009), own text Part II 'CORPORATE AFFAIRS COMMISSION' Section 2 'Establishment of Corporate Affairs Commission' (sierra-leone.org's hosted copy, fetched directly; cac.gov.sl itself did not resolve for this iteration -- honest ACCESS gap; independently corroborated via SLIEPA's own 'Starting a Business' page, which names CAC directly, states registration is free of charge, and gives register@cac.gov.sl / 15 Syke Street, Freetown). Tax/TIN registration: National Revenue Authority (NRA) under The National Revenue Authority Act, 2002 (Act No. 11 of 2002, per NPPA's own hosted PDF and independently per sierra-leone.org's listing; a separately-listed 'National Revenue Authority Act, 2022' on SierraLII could not be fetched/read this iteration -- an honest, undecided gap on whether/how it amends the 2002 Act), administering the Income Tax Act, 2000 (NRA's own consolidated edition, own cover page: 'THE CONSOLIDATED Income Tax Act, 2000 ... Updated to reflect all tax legislation through December 31, 2008 ... June 2009', NRA's own branding)"
          :provenance "https://nppa.gov.sl/acts-and-regulations/ ; https://nppa.gov.sl/wp-content/uploads/2025/07/Public_Procurement_Act_2016.pdf ; https://nppa.gov.sl/wp-content/uploads/2025/08/Public-Procurement-Regulations-2020-1.pdf ; https://sliepa.gov.sl/invest-in-sierra-leone/starting-a-business ; http://www.sierra-leone.org/Laws/2009-05.pdf ; https://sierralii.gov.sl/akn/sl/act/2022/21/eng@2022-09-23"
          :required-evidence ["Business Registration Certificate / Certificate of Incorporation issued by the Corporate Affairs Commission (CAC) under the Companies Act, 2009 (Public Procurement Regulations 2020, Regulation 21(3)(a): 'copies of the bidder's certificate of registration, certificate of incorporation, trading licence or similar document')"
                              "Tax registration and current tax clearance certificate issued by the National Revenue Authority (NRA) (Regulation 21(3)(b); Act Section 21(1)(i), own text: 'assessment by the National Revenue Authority to ascertain payment of taxes')"
                              "Evidence of payment of social security contributions (Act Section 21(1)(j); Regulation 21(3)(f)(xi))"
                              "Signed declaration that the bidder is not currently subject to debarment under Section 35(1) of the Act and Regulation 160, and that none of its directors/officers are involved with a currently-debarred bidder or consultant (Regulation 21(3)(e))"
                              "Signed declaration of no conflict of interest in relation to the procurement (Regulation 21(3)(c))"
                              "Signed declaration that neither the bidder nor its directors/officers have, within the preceding three years, been convicted of an offence relating to professional conduct or the making of false statements or misrepresentations as to qualifications to enter into a procurement contract (Regulation 21(3)(d))"
                              "Where the engagement declares :claims-margin-of-preference? true, the documentation required as evidence of eligibility for the margin of preference under Regulation 75(2)(b)"]
          :corporate-number-owner-authority "National Revenue Authority (NRA)"
          :corporate-number-legal-basis "The National Revenue Authority Act, 2002 (Act No. 11 of 2002), per NPPA's own hosted PDF ('the NRA Act 2002') and independently per sierra-leone.org's archive listing; administers the Income Tax Act, 2000 (NRA's own consolidated edition, own cover page, fetched directly). A separately-listed 'National Revenue Authority Act, 2022' (SierraLII) could not be fetched/read this iteration -- an honest, undecided gap, not claimed here"
          :corporate-number-provenance "https://nppa.gov.sl/wp-content/uploads/2025/07/nra_act_2002.pdf ; http://www.sierra-leone.org/Laws/2002-11.pdf ; http://www.sierra-leone.org/Laws/CITA-NRA.pdf"
          :margin-of-preference-owner-authority "National Public Procurement Authority (NPPA)"
          :margin-of-preference-legal-basis "The Public Procurement Act, 2016, Section 36 ('Margin of preference'), own text: 'A procuring entity may grant a margin of preference for the benefit of bids for work by domestic contractors or for the benefit of bids for domestically produced goods or for the benefit of domestic suppliers of services... The margin of preference shall be authorised by the Authority and shall be subject to approval by the Authority.' The Public Procurement Regulations, 2020, Regulation 75 ('Margin of preference'), own text: eligibility must be grounded in 'ownership, location of bidder or production facilities, origin of labour, raw material or components, extent of sub-contracting or association with local partners or any other relevant factor' (Regulation 75(2)(a)), and 'The percentage of preference in schemes issued by the Authority shall be between 5 and 12 percent' (Regulation 75(3)) -- both fetched and read directly as primary PDF text from nppa.gov.sl. FLAGSHIP genuinely new check for the iso3166 family (grep-verified absent as a governor check function name fleet-wide at build time): a REGULATORY-BAND-BOUNDED, MULTI-FACTOR-ELIGIBILITY discretionary bid-evaluation preference-rate gate -- see `marketentry.registry` docstring for the full comparison against every prior sibling's check shape"
          :margin-of-preference-criteria {:pct-floor 5
                                           :pct-ceiling 12
                                           :recognized-eligibility-grounds #{:ownership
                                                                              :location-of-bidder-or-production-facilities
                                                                              :origin-of-labour
                                                                              :origin-of-raw-material-or-components
                                                                              :extent-of-subcontracting-or-association-with-local-partners}}
          :margin-of-preference-provenance "https://nppa.gov.sl/wp-content/uploads/2025/07/Public_Procurement_Act_2016.pdf (Section 36) ; https://nppa.gov.sl/wp-content/uploads/2025/08/Public-Procurement-Regulations-2020-1.pdf (Regulation 75)"}
   "USA" {:name "United States"
          :owner-authority "U.S. General Services Administration (GSA) / SAM.gov"
          :legal-basis "Federal Acquisition Regulation (FAR); System for Award Management"
          :national-spec "SAM.gov entity registration + NAICS self-certification"
          :provenance "https://sam.gov/"
          :required-evidence ["EIN record"
                              "SAM.gov registration record"
                              "State business registration record"
                              "Authorized-representative record"]}
   "DEU" {:name "Germany"
          :owner-authority "Beschaffungsamt des BMI / e-Vergabe platforms"
          :legal-basis "Gesetz gegen Wettbewerbsbeschränkungen (GWB) / VgV"
          :national-spec "e-Vergabe supplier registration under EU procurement directives"
          :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract"
                              "e-Vergabe registration record"
                              "USt-IdNr record"
                              "Authorized-representative record"]}})

(defn spec-basis
  "The jurisdiction's requirement map, or nil -- nil means NO spec-basis,
  and the governor must hold any proposal that tries to assess or file
  on it."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report: how many of the requested jurisdictions actually
  have a spec-basis entry. Never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-sle R0: " (count catalog)
                 " jurisdictions seeded with an official spec-basis. "
                 "This is a starting catalog for market-entry navigation, "
                 "not a survey of all ~194 jurisdictions -- extend "
                 "`marketentry.facts/catalog`, never fabricate a "
                 "jurisdiction's requirements.")})))

(defn required-evidence-satisfied?
  "Does `submitted` (a set/coll of evidence keywords or strings) satisfy
  every evidence item listed for `iso3`? Missing spec-basis -> never
  satisfied."
  [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (let [need (count required-evidence)
          have (count (filter (set submitted) required-evidence))]
      (= need have))))

(defn evidence-checklist [iso3]
  (:required-evidence (spec-basis iso3) []))

(defn rep-spec-basis
  "The jurisdiction's representative-related requirement map, or nil when
  this catalog has no such regime. For SLE this is deliberately nil --
  this iteration did not find a Sierra-Leone-specific representative/
  director exclusion-extension provision in any primary text it was
  actually able to read."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))

(defn corporate-number-spec-basis
  "The jurisdiction's corporate-number / tax-id regime, or nil."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority
                       :corporate-number-legal-basis
                       :corporate-number-provenance]))))

(defn margin-of-preference-spec-basis
  "The jurisdiction's margin-of-preference regime, or nil. For SLE this
  is real and current -- the flagship check this vertical adds is
  grounded here (Public Procurement Act 2016 Section 36 + Public
  Procurement Regulations 2020 Regulation 75)."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:margin-of-preference-owner-authority sb)
      (select-keys sb [:margin-of-preference-owner-authority
                       :margin-of-preference-legal-basis
                       :margin-of-preference-criteria
                       :margin-of-preference-provenance]))))
