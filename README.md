# cloud-itonami-iso3166-sle

**SLE**: Sierra Leone.

- National Public Procurement Authority (NPPA) / The Public Procurement
  Act, 2016 (Act No. 1 of 2016) + Public Procurement Regulations, 2020
  (S.I. No. 5 of 2020) public-procurement compliance
- Corporate Affairs Commission (CAC) business/company registration
  under the Companies Act, 2009 (Act No. 5 of 2009) + National Revenue
  Authority (NRA) tax/TIN registration
- Public Procurement Act 2016 Section 36 / Regulations 2020 Regulation
  75 ('Margin of preference') -- a regulatory-band-bounded (5-12%),
  multi-factor-eligibility discretionary bid-evaluation preference-rate
  gate

AGPL-3.0-or-later.

## Market-entry / statute catalogs

Governed public-sector market-entry compliance actor, same architecture
as every `cloud-itonami-iso3166-*` sibling in this fleet:

- `src/marketentry/{facts,governor,phase,sim,operation,registry,store,
  marketentryllm}.cljc` -- the actor. `facts.cljc` cites the National
  Public Procurement Authority (NPPA, Public Procurement Act 2016 +
  Public Procurement Regulations 2020, both read as primary PDF text
  directly from `nppa.gov.sl`), the Corporate Affairs Commission (CAC,
  business/company registration under the Companies Act 2009, own text
  confirmed via `sierra-leone.org`'s hosted copy and independently via
  SLIEPA's own 'Starting a Business' page) and the National Revenue
  Authority (NRA, tax/TIN registration under the National Revenue
  Authority Act 2002, administering the Income Tax Act 2000).
  `governor.cljc`'s flagship check independently recomputes whether an
  engagement declaring `:claims-margin-of-preference? true` satisfies
  the Public Procurement Regulations 2020's own Regulation 75 ('Margin
  of preference') -- a two-part gate combining (1) a declared
  percentage that must fall within the Regulation's OWN statutory 5-12%
  band, and (2) a declared eligibility ground that must be one of the
  Regulation's own five NAMED categories (ownership / location of
  bidder or production facilities / origin of labour / origin of raw
  material or components / extent of sub-contracting or association
  with local partners) -- a check shape genuinely different from every
  other iso3166 sibling's (see the namespace docstrings for the full
  research trail and honestly-narrowed scope, including facts this
  iteration could NOT verify, such as whether/how a separately-listed
  'National Revenue Authority Act, 2022' relates to the 2002 Act, and
  CAC's own domain `cac.gov.sl` timing out on connection).
- `src/statute/facts.cljc` -- general-law catalog: the Employment Act,
  2023 (labor, SierraLII), the Income Tax Act, 2000 (tax, National
  Revenue Authority's own consolidated edition), the Companies Act,
  2009 (company/commercial-entity law, own Part II establishes CAC),
  and the National Investment Board Act, 2022 (investment law, repeals
  the Investment Promotion Act 2004 and the SLIEPA Act 2007 per its own
  Section 52(1)).

Every citation is curl/WebFetch-verified against an official source
(nppa.gov.sl, sliepa.gov.sl, sierralii.gov.sl, sierra-leone.org); the
Corporate Affairs Commission's own domain (`cac.gov.sl`) did not
resolve for this iteration -- an honestly-flagged ACCESS gap, not a
claim of non-existence, see `marketentry.facts`'s docstring. This
iteration also independently confirmed, via SLIEPA's own homepage
banner ('currently transitioning to become the National Investment
Board (NIB)') and separately via the National Investment Board Act,
2022's own Section 52(1) repeal clause, that SLIEPA is being
superseded by the National Investment Board -- two independent
official sources cross-confirming the same transition, neither copied
from the other.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Sierra Leone:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
