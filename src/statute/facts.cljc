(ns statute.facts
  "General-law compliance catalog for Sierra Leone (SLE) -- extends
  this repo's existing `marketentry.facts` (public-procurement market-
  entry only, narrow scope) with a second, orthogonal catalog of
  statutes a company operating in this jurisdiction must generally
  track for compliance. Mirrors cloud-itonami-iso3166-jpn/-deu/-bgr/
  -aze/-alb/-arm/-atg/-ben/-btn/-bwa/-caf/-est/-gmb/-gin/-lbr's
  `statute.facts` (ADR-2607141700, cloud-itonami-compliance-fact-
  federation).

  Every entry cites an OFFICIAL government-hosted URL -- never
  fabricated.

  - Labour law: the Employment Act, 2023 (Act No. 15 of 2023). This
    iteration confirmed its title, act number and commencement date
    directly from SierraLII (the Sierra Leone Legal Information
    Institute, `sierralii.gov.sl`, fetched directly), the official
    free-access legal-materials repository for Sierra Leone -- listed
    among the Institute's own legislation catalog as 'Employment Act,
    2023' with its own Akoma Ntoso citation date '2023-05-11'.
    Companion 'Employment Regulations, 2023' are separately listed on
    the same official source. This iteration did NOT independently
    fetch and read the Act's own full primary section text (only
    SierraLII's own catalog metadata for title/number/date), an
    honestly narrower confirmation than this catalog's other three
    entries below, which were each read as primary PDF/section text
    directly.
  - Tax law: the Income Tax Act, 2000 (Act No. 8 of 2000). This
    iteration downloaded and read the National Revenue Authority's own
    consolidated cover page directly (hosted via the long-running
    `sierra-leone.org` Sierra Leone laws archive, fetched directly),
    own text: 'NATIONAL REVENUE AUTHORITY ... THE CONSOLIDATED Income
    Tax Act, 2000 ... Updated to reflect all tax legislation through
    December 31, 2008 ... June 2009' -- own NRA branding/logo on the
    cover page, not a third-party paraphrase. This iteration
    independently corroborated the Act's existence and number from a
    SEPARATE listing on `sierra-leone.org`'s own laws index: 'The
    Income Tax Act, 2000 [No. 8 of 2000] ... An Act to consolidate,
    with amendments, the law relating to the taxation of incomes'. The
    National Revenue Authority Act, 2002 (Act No. 11 of 2002)
    establishes the NRA itself as the collecting authority (see
    `marketentry.facts`'s `corporate-number-*` entries) -- a SEPARATE
    law from the Income Tax Act, not duplicated here.
  - Company/commercial-entity law: the Companies Act, 2009 (Act No. 5
    of 2009). This iteration downloaded and read the Act's own PDF text
    directly (hosted on `sierra-leone.org`'s laws archive, fetched
    directly). The document's own cover page reads: 'ACT ... Supplement
    to the Sierra Leone Gazette Vol. CXL, No. 36 dated 13th August, 2009
    ... THE COMPANIES ACT, 2009', and its own Arrangement of Sections
    names 'PART II - CORPORATE AFFAIRS COMMISSION -- 2. Establishment of
    Corporate Affairs Commission. 3. Membership of Commission. ... 9.
    Appointment of Registrar.' -- the primary statutory basis for the
    Corporate Affairs Commission (CAC) this catalog's `marketentry.
    facts` `:national-spec` entry cites. This iteration also confirmed
    a later 'Companies Act, 2014 [No. 9 of 2014]' listed on the SAME
    `sierra-leone.org` index as an AMENDING act to the 2009 Companies
    Act, but did not independently fetch its own primary text this
    iteration -- an honest, unread-amendment gap (the underlying 2009
    Act's own CAC-establishing Part II is the primary text this catalog
    cites and was actually read).
  - Investment law: the National Investment Board Act, 2022 (Act No.
    11 of 2022). This iteration fetched and read this Act's own text
    directly from SierraLII (`sierralii.gov.sl`, fetched directly),
    own long title: 'Being an Act to establish an investment board to
    promote investment opportunities, to act as a facilitating body and
    assist investors to obtain facilities relating to their business
    enterprises and generally to improve the investment climate of
    Sierra Leone'. Its own Section 52(1) repeals '(a) The Investment
    Promotion Act 2004; (b) The Sierra Leone Investment and Export
    Promotion Agency [Act] 2007' -- this iteration independently
    cross-confirmed this repeal is real and current by separately
    observing (via `sliepa.gov.sl`, fetched directly, a different
    official domain) that SLIEPA's OWN homepage carries a banner
    stating it is 'currently transitioning to become the National
    Investment Board (NIB)', an independent corroboration from the
    predecessor agency's own site that this Act supersedes it. See
    `marketentry.facts` for this Act's own Section 7(1)(p) (local-
    content sector-reservation power) and Section 31(2)(a)/(b)
    (delegated minimum-investment-threshold and priority-area gate),
    both of which this iteration found are wholly delegated to Board
    policy rather than enumerated in the Act itself -- an honest,
    delegated-not-enumerated gap, the reason this catalog's flagship
    governor check is instead grounded in the Public Procurement
    Regulations 2020's own Regulation 75 (margin of preference), which
    DOES state its own numeric band directly.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"SLE"
   [{:statute/id "sle.employment-act-2023"
     :statute/title "Employment Act, 2023"
     :statute/jurisdiction "SLE"
     :statute/kind :law
     :statute/law-number "Employment Act, 2023 (Act No. 15 of 2023), per SierraLII's own legislation catalog (sierralii.gov.sl, fetched directly), Akoma Ntoso citation date 2023-05-11. Companion 'Employment Regulations, 2023' separately listed on the same official source. This iteration confirmed title/number/date from SierraLII's own catalog metadata; it did not independently fetch and read the Act's own full primary section text this iteration -- an honest, narrower-than-usual confirmation for this entry"
     :statute/url "https://sierralii.gov.sl/akn/sl/act/2023/15/eng@2023-05-11"
     :statute/url-provenance :official-sierralii-gov-sl
     :statute/enacted-date "2023-05-11"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor}}
    {:statute/id "sle.income-tax-act-2000"
     :statute/title "Income Tax Act, 2000"
     :statute/jurisdiction "SLE"
     :statute/kind :law
     :statute/law-number "The Income Tax Act, 2000 (Act No. 8 of 2000) -- own text confirmed directly from the National Revenue Authority's own consolidated cover page (own branding: 'NATIONAL REVENUE AUTHORITY ... THE CONSOLIDATED Income Tax Act, 2000 ... Updated to reflect all tax legislation through December 31, 2008 ... June 2009'), hosted via the sierra-leone.org archive, fetched directly. Independently corroborated by a SEPARATE sierra-leone.org index listing: 'The Income Tax Act, 2000 [No. 8 of 2000] ... An Act to consolidate, with amendments, the law relating to the taxation of incomes'. The National Revenue Authority Act, 2002 (Act No. 11 of 2002) is the SEPARATE law establishing the NRA as collecting authority (see marketentry.facts corporate-number-* entries), not duplicated here"
     :statute/url "http://www.sierra-leone.org/Laws/CITA-NRA.pdf"
     :statute/url-provenance :official-nra-via-sierra-leone-org
     :statute/enacted-date "2000"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:tax}}
    {:statute/id "sle.companies-act-2009"
     :statute/title "Companies Act, 2009"
     :statute/jurisdiction "SLE"
     :statute/kind :law
     :statute/law-number "The Companies Act, 2009 (Act No. 5 of 2009) -- own text, fetched directly: 'ACT ... Supplement to the Sierra Leone Gazette Vol. CXL, No. 36 dated 13th August, 2009 ... THE COMPANIES ACT, 2009'; own Arrangement of Sections names 'PART II - CORPORATE AFFAIRS COMMISSION -- 2. Establishment of Corporate Affairs Commission. ... 9. Appointment of Registrar.' -- the primary statutory basis for CAC. A later 'Companies Act, 2014 [No. 9 of 2014]' amends this Act per the same sierra-leone.org index; this iteration did not independently fetch the 2014 amending Act's own primary text -- an honest, unread-amendment gap"
     :statute/url "http://www.sierra-leone.org/Laws/2009-05.pdf"
     :statute/url-provenance :official-sierra-leone-org
     :statute/enacted-date "2009-08-13"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance}}
    {:statute/id "sle.national-investment-board-act-2022"
     :statute/title "National Investment Board Act, 2022"
     :statute/jurisdiction "SLE"
     :statute/kind :law
     :statute/law-number "National Investment Board Act, 2022 (Act No. 11 of 2022) -- own text, fetched directly from SierraLII: 'Being an Act to establish an investment board to promote investment opportunities...'. Own Section 52(1) repeals the Investment Promotion Act 2004 and the Sierra Leone Investment and Export Promotion Agency [Act] 2007 -- independently cross-confirmed via a SEPARATE official domain (sliepa.gov.sl's own homepage banner: 'currently transitioning to become the National Investment Board (NIB)'). See marketentry.facts for this Act's own Section 7(1)(p) / Section 31(2)(a)/(b), both delegated to Board policy rather than enumerated in the Act itself"
     :statute/url "https://sierralii.gov.sl/akn/sl/act/2022/11/eng@2022-07-14"
     :statute/url-provenance :official-sierralii-gov-sl
     :statute/enacted-date "2022-07-14"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:investment}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-sle statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "SLE")) " SLE statute(s) seeded with an "
                 "official citation. Extend `statute.facts/catalog`, "
                 "never fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :tax)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
