(ns culture.facts
  "Country-level regional-culture catalog for Sierra Leone (SLE) --
  national dishes, protected products, beverages, crafts, festivals and
  heritage sites, per ADR-2607171400 addendum 2 (cloud-itonami-
  municipality-culture-catalog Wave 1, in com-junkawasaki/root). Sibling
  namespace to `marketentry.facts` / `statute.facts` (ADR-2607141700);
  city-level counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"SLE"
   [{:culture/id "sle.dish.cassava-leaf-stew"
     :culture/name "Cassava leaf stew"
     :culture/country "SLE"
     :culture/kind :dish
     :culture/summary "Stew of finely pounded cassava leaves cooked into palaver sauce with red palm oil, onions, pepper, fish or meat; the article states cassava leaves have been called Sierra Leone's national dish."
     :culture/url "https://en.wikipedia.org/wiki/Sierra_Leonean_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sle.dish.groundnut-stew"
     :culture/name "Groundnut stew"
     :culture/country "SLE"
     :culture/kind :dish
     :culture/summary "Peanut stew, often with chicken and vegetables, described as often served to families as a large meal in Sierra Leone."
     :culture/url "https://en.wikipedia.org/wiki/Sierra_Leonean_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sle.dish.fufu"
     :culture/name "Fufu"
     :culture/country "SLE"
     :culture/kind :dish
     :culture/summary "Pounded-cassava staple; the article states cassava is pounded to make fufu in Sierra Leone, and its leaves are separately cooked into the cassava-leaf stew."
     :culture/url "https://en.wikipedia.org/wiki/Sierra_Leonean_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sle.beverage.poyo"
     :culture/name "Poyo"
     :culture/country "SLE"
     :culture/kind :beverage
     :culture/summary "Fermented palm wine made in Sierra Leone from various palm species; the article states it plays an important role among the Limba people (\"he who brings poyo brings life\") and is served at weddings, births and funeral wakes."
     :culture/url "https://en.wikipedia.org/wiki/Palm_wine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sle.craft.sowei-mask"
     :culture/name "Sowei mask"
     :culture/name-local "Sowo"
     :culture/country "SLE"
     :culture/kind :craft
     :culture/summary "Polished black wooden helmet mask of the Sande (also bondo/bundu) women's initiation society, practiced in Sierra Leone among the Mende, Temne, Kono, Limba, Sherbro and Yalunka; the article notes women wearing masks is unique to this region within West Africa."
     :culture/url "https://en.wikipedia.org/wiki/Sande_society"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sle.heritage.cotton-tree"
     :culture/name "Cotton Tree"
     :culture/country "SLE"
     :culture/kind :heritage
     :culture/summary "Kapok tree in Freetown that became historically important in 1792 when Black Loyalists founded the city; described by Sierra Leone's president as the strongest symbol of the country's national story, and featured on Sierra Leone's first 1964 banknotes."
     :culture/url "https://en.wikipedia.org/wiki/Cotton_Tree_(Sierra_Leone)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sle.heritage.bunce-island"
     :culture/name "Bunce Island"
     :culture/country "SLE"
     :culture/kind :heritage
     :culture/summary "British slave-trading castle established c.1670 in the Sierra Leone River, operated until c.1840; designated Sierra Leone's first officially protected historic site in 1948 and protected by the Sierra Leone Monuments and Relics Commission, described in the article as \"the most important historic site in Africa for the United States\"."
     :culture/url "https://en.wikipedia.org/wiki/Bunce_Island"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-sle culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "SLE"))
                 " SLE entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
