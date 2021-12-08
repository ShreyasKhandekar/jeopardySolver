# Output
This is the output from our best system of retrieval: English Analyzer on Full
Documents without lemmatization.

```bash
C:\Users\khand\.jdks\openjdk-16.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.1\lib\idea_rt.jar=1109:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\khand\OneDrive - University of Arizona\Study\UArizona\Classes\Fall 2021\CSC 483\Project\jeopardySolver\target\classes;C:\Users\khand\.m2\repository\org\apache\lucene\lucene-core\8.10.1\lucene-core-8.10.1.jar;C:\Users\khand\.m2\repository\org\apache\lucene\lucene-queryparser\8.10.1\lucene-queryparser-8.10.1.jar;C:\Users\khand\.m2\repository\org\apache\lucene\lucene-queries\8.10.1\lucene-queries-8.10.1.jar;C:\Users\khand\.m2\repository\org\apache\lucene\lucene-sandbox\8.10.1\lucene-sandbox-8.10.1.jar;C:\Users\khand\.m2\repository\org\apache\lucene\lucene-analyzers-common\8.10.1\lucene-analyzers-common-8.10.1.jar;C:\Users\khand\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-jdk8\1.5.31\kotlin-stdlib-jdk8-1.5.31.jar;C:\Users\khand\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib\1.5.31\kotlin-stdlib-1.5.31.jar;C:\Users\khand\.m2\repository\org\jetbrains\annotations\13.0\annotations-13.0.jar;C:\Users\khand\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-common\1.5.31\kotlin-stdlib-common-1.5.31.jar;C:\Users\khand\.m2\repository\org\jetbrains\kotlin\kotlin-stdlib-jdk7\1.5.31\kotlin-stdlib-jdk7-1.5.31.jar;C:\Users\khand\.m2\repository\edu\stanford\nlp\stanford-corenlp\4.3.2\stanford-corenlp-4.3.2.jar;C:\Users\khand\.m2\repository\com\apple\AppleJavaExtensions\1.4\AppleJavaExtensions-1.4.jar;C:\Users\khand\.m2\repository\de\jollyday\jollyday\0.4.9\jollyday-0.4.9.jar;C:\Users\khand\.m2\repository\org\apache\commons\commons-lang3\3.3.1\commons-lang3-3.3.1.jar;C:\Users\khand\.m2\repository\javax\servlet\javax.servlet-api\3.0.1\javax.servlet-api-3.0.1.jar;C:\Users\khand\.m2\repository\xom\xom\1.3.7\xom-1.3.7.jar;C:\Users\khand\.m2\repository\xerces\xercesImpl\2.8.0\xercesImpl-2.8.0.jar;C:\Users\khand\.m2\repository\xml-apis\xml-apis\1.3.03\xml-apis-1.3.03.jar;C:\Users\khand\.m2\repository\xalan\xalan\2.7.2\xalan-2.7.2.jar;C:\Users\khand\.m2\repository\xalan\serializer\2.7.2\serializer-2.7.2.jar;C:\Users\khand\.m2\repository\joda-time\joda-time\2.10.5\joda-time-2.10.5.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-core\0.39\ejml-core-0.39.jar;C:\Users\khand\.m2\repository\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-ddense\0.39\ejml-ddense-0.39.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-simple\0.39\ejml-simple-0.39.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-fdense\0.39\ejml-fdense-0.39.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-cdense\0.39\ejml-cdense-0.39.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-zdense\0.39\ejml-zdense-0.39.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-dsparse\0.39\ejml-dsparse-0.39.jar;C:\Users\khand\.m2\repository\org\ejml\ejml-fsparse\0.39\ejml-fsparse-0.39.jar;C:\Users\khand\.m2\repository\org\glassfish\javax.json\1.0.4\javax.json-1.0.4.jar;C:\Users\khand\.m2\repository\com\google\protobuf\protobuf-java\3.11.4\protobuf-java-3.11.4.jar;C:\Users\khand\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\khand\.m2\repository\javax\xml\bind\jaxb-api\2.4.0-b180830.0359\jaxb-api-2.4.0-b180830.0359.jar;C:\Users\khand\.m2\repository\com\sun\xml\bind\jaxb-core\2.3.0.1\jaxb-core-2.3.0.1.jar;C:\Users\khand\.m2\repository\com\sun\xml\bind\jaxb-impl\2.4.0-b180830.0438\jaxb-impl-2.4.0-b180830.0438.jar;C:\Users\khand\.m2\repository\edu\stanford\nlp\stanford-corenlp\4.3.2\stanford-corenlp-4.3.2-models.jar;C:\Users\khand\.m2\repository\org\slf4j\slf4j-api\1.7.5\slf4j-api-1.7.5.jar;C:\Users\khand\.m2\repository\org\slf4j\slf4j-simple\1.6.4\slf4j-simple-1.6.4.jar" jeopardy.JeopardySolverKt -t
0 [main] INFO edu.stanford.nlp.pipeline.StanfordCoreNLP - Adding annotator tokenize
15 [main] INFO edu.stanford.nlp.pipeline.StanfordCoreNLP - Adding annotator ssplit
22 [main] INFO edu.stanford.nlp.pipeline.StanfordCoreNLP - Adding annotator pos
845 [main] INFO edu.stanford.nlp.tagger.maxent.MaxentTagger - Loading POS tagger from edu/stanford/nlp/models/pos-tagger/english-left3words-distsim.tagger ... done [0.8 sec].
846 [main] INFO edu.stanford.nlp.pipeline.StanfordCoreNLP - Adding annotator lemma


Question: The dominant paper in our nation's capital, it's among the top 10 U.S. papers in circulation
Query: NEWSPAPERS The dominant paper in our nation's capital, it's among the top 10 U.S. papers in circulation
Answer: Media of the United States
Solution: [The Washington Post]


Question: The practice of pre-authorizing presidential use of force dates to a 1955 resolution re: this island near mainland China
Query: OLD YEAR'S RESOLUTIONS The practice of pre-authorizing presidential use of force dates to a 1955 resolution re: this island near mainland China
Answer: United Nations General Assembly Resolution 505
Solution: [Taiwan]


Question: Daniel Hertzberg & James B. Stewart of this paper shared a 1988 Pulitzer for their stories about insider trading
Query: NEWSPAPERS Daniel Hertzberg & James B. Stewart of this paper shared a 1988 Pulitzer for their stories about insider trading
Answer: The Wall Street Journal
Solution: [The Wall Street Journal]


Question: Song that says, "you make me smile with my heart; your looks are laughable, unphotographable"
Query: BROADWAY LYRICS Song that says, "you make me smile with my heart; your looks are laughable, unphotographable"
Answer: Keyshia Cole
Solution: [My Funny Valentine]


Question: In 2011 bell ringers for this charity started accepting digital donations to its red kettle
Query: POTPOURRI In 2011 bell ringers for this charity started accepting digital donations to its red kettle
Answer: The Salvation Army
Solution: [The Salvation Army, Salvation Army]


Question: The Naples Museum of Art
Query: STATE OF THE ART MUSEUM   We'll give you the museum. You give us the state. The Naples Museum of Art
Answer: Michael Bierut
Solution: [Florida]


Question: This Italian painter depicted the "Adoration of the Golden Calf"
Query: "TIN" MEN This Italian painter depicted the "Adoration of the Golden Calf"
Answer: Nicola Cianfanelli
Solution: [Tintoretto]


Question: This woman who won consecutive heptathlons at the Olympics went to UCLA on a basketball scholarship
Query: UCLA CELEBRITY ALUMNI This woman who won consecutive heptathlons at the Olympics went to UCLA on a basketball scholarship
Answer: Jackie Joyner-Kersee
Solution: [Jackie Joyner-Kersee]


Question: Originally this club's emblem was a wagon wheel; now it's a gearwheel with 24 cogs & 6 spokes
Query: SERVICE ORGANIZATIONS Originally this club's emblem was a wagon wheel; now it's a gearwheel with 24 cogs & 6 spokes
Answer: De Poelen, Dronrijp
Solution: [Rotary International]


Question: Several bridges, including El Tahrir, cross the Nile in this capital
Query: AFRICAN CITIES Several bridges, including El Tahrir, cross the Nile in this capital
Answer: Cairo
Solution: [Cairo]


Question: After the fall of France in 1940, this general told his country, "France has lost a battle. But France has not lost the war"
Query: HISTORICAL QUOTES After the fall of France in 1940, this general told his country, "France has lost a battle. But France has not lost the war"
Answer: Hubert Lyautey
Solution: [Charles de Gaulle, de Gaulle]


Question: The Taft Museum of Art
Query: STATE OF THE ART MUSEUM   We'll give you the museum. You give us the state. The Taft Museum of Art
Answer: Michael Bierut
Solution: [Ohio]


Question: The mast from the USS Maine is part of the memorial to the ship & crew at this national cemetery
Query: CEMETERIES The mast from the USS Maine is part of the memorial to the ship & crew at this national cemetery
Answer: USS Arizona Memorial
Solution: [Arlington National Cemetery, Arlington Cemetery]


Question: In 2009: Joker on film
Query: GOLDEN GLOBE WINNERS In 2009: Joker on film
Answer: Jimmy Harry
Solution: [Heath Ledger]


Question: It was the peninsula fought over in the peninsular war of 1808 to 1814
Query: HISTORICAL HODGEPODGE It was the peninsula fought over in the peninsular war of 1808 to 1814
Answer: Vicente Genaro de Quesada
Solution: [Iberia, Iberian Peninsula]


Question: In 1980 China founded a center for these cute creatures in its bamboo-rich Wolong Nature Preserve
Query: CONSERVATION In 1980 China founded a center for these cute creatures in its bamboo-rich Wolong Nature Preserve
Answer: Chengdu
Solution: [Panda, Giant panda]


Question: 1988: "Father Figure"
Query: '80s NO.1 HITMAKERS 1988: "Father Figure"
Answer: Schweizer SGS 1-24
Solution: [George Michael]


Question: In an essay defending this 2011 film, Myrlie Evers-Williams said, "My mother was" this film "& so was her mother"
Query: AFRICAN-AMERICAN WOMEN In an essay defending this 2011 film, Myrlie Evers-Williams said, "My mother was" this film "& so was her mother"
Answer: Medgar Evers
Solution: [The Help]


Question: Father Michael McGivney founded this fraternal society for Catholic laymen in 1882
Query: SERVICE ORGANIZATIONS Father Michael McGivney founded this fraternal society for Catholic laymen in 1882
Answer: Knights of Columbus
Solution: [Knights of Columbus]


Question: Early projects of the WWF, this organization, included work with the bald eagle & the red wolf
Query: CONSERVATION Early projects of the WWF, this organization, included work with the bald eagle & the red wolf
Answer: United States Fish and Wildlife Service
Solution: [World Wide Fund, World Wide Fund for Nature]


Question: Indonesia's largest lizard, it's protected from poachers, though we wish it could breathe fire to do the job itself
Query: CONSERVATION Indonesia's largest lizard, it's protected from poachers, though we wish it could breathe fire to do the job itself
Answer: Komodo dragon
Solution: [Komodo dragon]


Question: Nov. 28, 1929! This man & his chief pilot Bernt Balchen fly to South Pole! Yowza! You'll be an admirable admiral, sir!
Query: 1920s NEWS FLASH! Nov. 28, 1929! This man & his chief pilot Bernt Balchen fly to South Pole! Yowza! You'll be an admirable admiral, sir!
Answer: Keith Park
Solution: [Richard Byrd, Richard E. Byrd]


Question: On May 5, 1878 Alice Chambers was the last person buried in this Dodge City, Kansas cemetery
Query: CEMETERIES On May 5, 1878 Alice Chambers was the last person buried in this Dodge City, Kansas cemetery
Answer: Boot Hill
Solution: [Boot Hill]


Question: The Royal Palace grounds feature a statue of King Norodom, who in the late 1800s was compelled to first put his country under the control of this European power; of course, it was sculpted in that country
Query: CAMBODIAN HISTORY & CULTURE The Royal Palace grounds feature a statue of King Norodom, who in the late 1800s was compelled to first put his country under the control of this European power; of course, it was sculpted in that country
Answer: Politics of Cambodia
Solution: [France]


Question: In the 400s B.C. this Chinese philosopher went into exile for 12 years
Query: HISTORICAL HODGEPODGE In the 400s B.C. this Chinese philosopher went into exile for 12 years
Answer: Zhang Binglin
Solution: [Confucius]


Question: Bessie Coleman, the first black woman licensed as a pilot, landed a street named in her honor at this Chicago airport
Query: AFRICAN-AMERICAN WOMEN Bessie Coleman, the first black woman licensed as a pilot, landed a street named in her honor at this Chicago airport
Answer: Bessie Coleman
Solution: [O'Hare, O'Hare International Airport]


Question: The Ammonites held sway in this Mideast country in the 1200s B.C. & the capital is named for them
Query: HISTORICAL HODGEPODGE The Ammonites held sway in this Mideast country in the 1200s B.C. & the capital is named for them
Answer: Raichur district
Solution: [Jordan]


Question: "The Sum of All Fears"; he also won a screenwriting Oscar for "Good Will Hunting"
Query: HE PLAYED A GUY NAMED JACK RYAN IN... "The Sum of All Fears"; he also won a screenwriting Oscar for "Good Will Hunting"
Answer: Peter Shaffer
Solution: [Ben Affleck]


Question: One of the N.Y. Times' headlines on this landmark 1973 Supreme Court decision was "Cardinals shocked"
Query: POTPOURRI One of the N.Y. Times' headlines on this landmark 1973 Supreme Court decision was "Cardinals shocked"
Answer: Griswold v. Connecticut
Solution: [Roe v. Wade]


Question: France's Philip IV--known as "The Fair"--had Jacques De Molay, the last Grand Master of this order, burned in 1314
Query: I'M BURNIN' FOR YOU France's Philip IV--known as "The Fair"--had Jacques De Molay, the last Grand Master of this order, burned in 1314
Answer: Philip IV of France
Solution: [Knights Templar]


Question: The Georgia O'Keeffe Museum
Query: STATE OF THE ART MUSEUM   We'll give you the museum. You give us the state. The Georgia O'Keeffe Museum
Answer: Bernice Johnson Reagon
Solution: [New Mexico]


Question: The name of this largest Moroccan city combines 2 Spanish words
Query: AFRICAN CITIES The name of this largest Moroccan city combines 2 Spanish words
Answer: Casablanca
Solution: [Casablanca]


Question: Jell-O
Query: NAME THE PARENT COMPANY Jell-O
Answer: Jell-O
Solution: [Kraft Foods]


Question: 2011: Chicago mayor Tom Kane
Query: GOLDEN GLOBE WINNERS 2011: Chicago mayor Tom Kane
Answer: Olympia Dukakis
Solution: [Kelsey Grammer]


Question: Title residence of Otter, Flounder, Pinto & Bluto in a 1978 comedy
Query: THE RESIDENTS Title residence of Otter, Flounder, Pinto & Bluto in a 1978 comedy
Answer: Animal House
Solution: [Animal House]


Question: Neurobiologist Amy Farrah Fowler on "The Big Bang Theory", in real life she has a Ph.D. in neuroscience from UCLA
Query: UCLA CELEBRITY ALUMNI Neurobiologist Amy Farrah Fowler on "The Big Bang Theory", in real life she has a Ph.D. in neuroscience from UCLA
Answer: Mayim Bialik
Solution: [Mayim Bialik]


Question: In "The Deadlocked Election of 1800", James R. Sharp outlines the fall of this dueling vice president
Query: NOTES FROM THE CAMPAIGN TRAIL In "The Deadlocked Election of 1800", James R. Sharp outlines the fall of this dueling vice president
Answer: Aaron Burr
Solution: [Aaron Burr]


Question: He served in the KGB before becoming president & then prime minister of Russia
Query: "TIN" MEN He served in the KGB before becoming president & then prime minister of Russia
Answer: Vladimir Putin
Solution: [Vladimir Putin, Putin]


Question: When asked to describe herself, she says first & foremost, she is Malia & Sasha's mom
Query: AFRICAN-AMERICAN WOMEN When asked to describe herself, she says first & foremost, she is Malia & Sasha's mom
Answer: Michelle Obama
Solution: [Michelle Obama]


Question: She wrote, "My candle burns at both ends... but, ah, my foes, and oh, my friends--it gives a lovely light"
Query: POETS & POETRY She wrote, "My candle burns at both ends... but, ah, my foes, and oh, my friends--it gives a lovely light"
Answer: Sonnet 133
Solution: [Edna St. Vincent Millay]


Question: In this Finnish city, the Lutheran Cathedral, also known as Tuomiokirkko
Query: CAPITAL CITY CHURCHES   We'll give you the church. You tell us the capital city in which it is located. In this Finnish city, the Lutheran Cathedral, also known as Tuomiokirkko
Answer: Savonlinna
Solution: [Helsinki]


Question: Milton Bradley games
Query: NAME THE PARENT COMPANY Milton Bradley games
Answer: Axis & Allies
Solution: [Hasbro]


Question: The Kentucky & Virginia resolutions were passed to protest these controversial 1798 acts of Congress
Query: OLD YEAR'S RESOLUTIONS The Kentucky & Virginia resolutions were passed to protest these controversial 1798 acts of Congress
Answer: Kentucky and Virginia Resolutions
Solution: [The Alien and Sedition Acts]


Question: 1983: "Beat It"
Query: '80s NO.1 HITMAKERS 1983: "Beat It"
Answer: Fontana Records
Solution: [Michael Jackson]


Question: In 2009: Sookie Stackhouse
Query: GOLDEN GLOBE WINNERS In 2009: Sookie Stackhouse
Answer: Anna Paquin
Solution: [Anna Paquin]


Question: This member of the Nixon & Ford cabinets was born in Furth, Germany in 1923
Query: HISTORICAL HODGEPODGE This member of the Nixon & Ford cabinets was born in Furth, Germany in 1923
Answer: William B. Saxbe
Solution: [Henry Kissinger]


Question: The High Kirk of St. Giles, where John Knox was minister
Query: CAPITAL CITY CHURCHES   We'll give you the church. You tell us the capital city in which it is located. The High Kirk of St. Giles, where John Knox was minister
Answer: John Knox
Solution: [Edinburgh]


Question: For the brief time he attended, he was a rebel with a cause, even landing a lead role in a 1950 stage production
Query: UCLA CELEBRITY ALUMNI For the brief time he attended, he was a rebel with a cause, even landing a lead role in a 1950 stage production
Answer: James Dean
Solution: [James Dean]


Question: Fisher-Price toys
Query: NAME THE PARENT COMPANY Fisher-Price toys
Answer: Little People
Solution: [Mattel]


Question: In a 1959 American kitchen exhibit in Moscow, he told Khrushchev, "In America, we like to make life easier for women"
Query: HISTORICAL QUOTES In a 1959 American kitchen exhibit in Moscow, he told Khrushchev, "In America, we like to make life easier for women"
Answer: American National Exhibition
Solution: [Richard Nixon, Nixon]


Question: One of his "Tales of a Wayside Inn" begins, "Listen, my children, and you shall hear of the midnight ride of Paul Revere"
Query: POETS & POETRY One of his "Tales of a Wayside Inn" begins, "Listen, my children, and you shall hear of the midnight ride of Paul Revere"
Answer: Henry Wadsworth Longfellow
Solution: [Henry Wadsworth Longfellow]


Question: This bestseller about problems on the McCain-Palin ticket became an HBO movie with Julianne Moore
Query: NOTES FROM THE CAMPAIGN TRAIL This bestseller about problems on the McCain-Palin ticket became an HBO movie with Julianne Moore
Answer: Game Change
Solution: [Game Change]


Question: A 2-part episode of "JAG" introduced this Mark Harmon drama
Query: THAT 20-AUGHTS SHOW A 2-part episode of "JAG" introduced this Mark Harmon drama
Answer: Bozo the Clown
Solution: [NCIS]


Question: This port is the southernmost of South Africa's 3 capitals
Query: AFRICAN CITIES This port is the southernmost of South Africa's 3 capitals
Answer: Urbanization in Africa
Solution: [Cape Town]


Question: Keats was quoting this Edmund Spenser poem when he told Shelley to "'load every rift' of your subject with ore"
Query: THE QUOTABLE KEATS Keats was quoting this Edmund Spenser poem when he told Shelley to "'load every rift' of your subject with ore"
Answer: John Keats
Solution: [The Faerie Queene]


Question: In an 1819 letter Keats wrote that this lord & poet "cuts a figure, but he is not figurative"
Query: THE QUOTABLE KEATS In an 1819 letter Keats wrote that this lord & poet "cuts a figure, but he is not figurative"
Answer: John Keats
Solution: [Lord Byron]


Question: This clear Greek liqueur is quite potent, so it's usually mixed with water, which turns it white & cloudy
Query: GREEK FOOD & DRINK This clear Greek liqueur is quite potent, so it's usually mixed with water, which turns it white & cloudy
Answer: Ouzo
Solution: [Ouzo]


Question: Feb. 1, National Freedom Day, is the date in 1865 when a resolution sent the states an amendment ending this
Query: OLD YEAR'S RESOLUTIONS Feb. 1, National Freedom Day, is the date in 1865 when a resolution sent the states an amendment ending this
Answer: Kentucky and Virginia Resolutions
Solution: [Slavery, Slavery in the United States]


Question: This person is the queen's representative in Canada; currently the office is held by David Johnston
Query: RANKS & TITLES This person is the queen's representative in Canada; currently the office is held by David Johnston
Answer: Governor General of Canada
Solution: [Governor General of Canada]


Question: He earned the "fifth Beatle" nickname by producing all of the Beatles' albums
Query: "TIN" MEN He earned the "fifth Beatle" nickname by producing all of the Beatles' albums
Answer: Fifth Beatle
Solution: [George Martin]


Question: Early in their careers, Mark Twain & Bret Harte wrote pieces for this California city's Chronicle
Query: NEWSPAPERS Early in their careers, Mark Twain & Bret Harte wrote pieces for this California city's Chronicle
Answer: Bret Harte
Solution: [San Francisco]


Question: Large specimens of this marsupial can leap over barriers 6 feet high
Query: POTPOURRI Large specimens of this marsupial can leap over barriers 6 feet high
Answer: Fauna of Australia
Solution: [Kangaroo]


Question: Because it's cured & stored in brine, this crumbly white cheese made from sheep's milk is often referred to as pickled cheese
Query: GREEK FOOD & DRINK Because it's cured & stored in brine, this crumbly white cheese made from sheep's milk is often referred to as pickled cheese
Answer: Feta
Solution: [Feta]


Question: 1927! Gene Tunney takes a long count in the squared circle but rises to defeat this "Manassa Mauler"! Howzabout that!
Query: 1920s NEWS FLASH! 1927! Gene Tunney takes a long count in the squared circle but rises to defeat this "Manassa Mauler"! Howzabout that!
Answer: Jack Dempsey
Solution: [Jack Dempsey]


Question: Italian for "leader", it was especially applied to Benito Mussolini
Query: RANKS & TITLES Italian for "leader", it was especially applied to Benito Mussolini
Answer: Duce
Solution: [Duce]


Question: The Kalamazoo Institute of Arts
Query: STATE OF THE ART MUSEUM   We'll give you the museum. You give us the state. The Kalamazoo Institute of Arts
Answer: Michael Bierut
Solution: [Michigan]


Question: The Sun Valley Center for the Arts
Query: STATE OF THE ART MUSEUM   We'll give you the museum. You give us the state. The Sun Valley Center for the Arts
Answer: Red Jacket
Solution: [Idaho]


Question: You can't mention this shortstop without mentioning his double-play associates Evers & Chance
Query: "TIN" MEN You can't mention this shortstop without mentioning his double-play associates Evers & Chance
Answer: Hughie Jennings
Solution: [Joe Tinker]


Question: In 1840 Horace Greeley began publishing "The Log Cabin", a weekly campaign paper in support of this Whig candidate
Query: NEWSPAPERS In 1840 Horace Greeley began publishing "The Log Cabin", a weekly campaign paper in support of this Whig candidate
Answer: Horace Greeley
Solution: [William Henry Harrison]


Question: Pierre Cauchon, Bishop of Beauvais, presided over the trial of this woman who went up in smoke May 30, 1431
Query: I'M BURNIN' FOR YOU Pierre Cauchon, Bishop of Beauvais, presided over the trial of this woman who went up in smoke May 30, 1431
Answer: Roman Catholic Diocese of Beauvais
Solution: [Joan of Arc, Jeanne d'Arc]


Question: This Wisconsin city claims to have built the USA's only granite dome
Query: COMPLETE DOM-INATION  Not "domination." This Wisconsin city claims to have built the USA's only granite dome
Answer: Saint Isaac's Cathedral
Solution: [Madison]


Question: This Georgia paper is known as the AJC for short
Query: NEWSPAPERS This Georgia paper is known as the AJC for short
Answer: The Atlanta Journal-Constitution
Solution: [The Atlanta Journal-Constitution]


Question: Wooden 2-story verandas in this Liberian capital are an architectural link to the U.S. south
Query: AFRICAN CITIES Wooden 2-story verandas in this Liberian capital are an architectural link to the U.S. south
Answer: Monrovia
Solution: [Monrovia]


Question: This New Orleans venue reopened Sept. 25, 2006
Query: COMPLETE DOM-INATION  Not "domination." This New Orleans venue reopened Sept. 25, 2006
Answer: Mercedes-Benz Superdome
Solution: [Mercedes-Benz Superdome, The Superdome]


Question: "The Hunt for Red October"; he went more comedic as Jack Donaghy on "30 Rock"
Query: HE PLAYED A GUY NAMED JACK RYAN IN... "The Hunt for Red October"; he went more comedic as Jack Donaghy on "30 Rock"
Answer: 30 Rock (season 6)
Solution: [Alec Baldwin]


Question: Rita Dove titled a collection of poems "On the Bus with" this woman
Query: AFRICAN-AMERICAN WOMEN Rita Dove titled a collection of poems "On the Bus with" this woman
Answer: Nellie Y. McKay
Solution: [Rosa Parks]


Question: "Patriot Games"; he's had other iconic roles, in space & underground
Query: HE PLAYED A GUY NAMED JACK RYAN IN... "Patriot Games"; he's had other iconic roles, in space & underground
Answer: Raiden (Metal Gear)
Solution: [Harrison Ford]


Question: This sacred structure dates from the late 600's A.D.
Query: COMPLETE DOM-INATION  Not "domination." This sacred structure dates from the late 600's A.D.
Answer: Izamal
Solution: [Dome of the Rock]


Question: 1988: "Man In The Mirror"
Query: '80s NO.1 HITMAKERS 1988: "Man In The Mirror"
Answer: The Other Man's Grass Is Always Greener
Solution: [Michael Jackson]


Question: Matthias Church, or Matyas Templom, where Franz Joseph was crowned in 1867
Query: CAPITAL CITY CHURCHES   We'll give you the church. You tell us the capital city in which it is located. Matthias Church, or Matyas Templom, where Franz Joseph was crowned in 1867
Answer: History of Buda Castle
Solution: [Budapest]


Question: Attending UCLA in the '60s, he was no "Meathead", he just played one later on television
Query: UCLA CELEBRITY ALUMNI Attending UCLA in the '60s, he was no "Meathead", he just played one later on television
Answer: Rob Reiner
Solution: [Rob Reiner]


Question: Kinch, Carter & LeBeau were all residents of Stalag 13 on this TV show
Query: THE RESIDENTS Kinch, Carter & LeBeau were all residents of Stalag 13 on this TV show
Answer: Hogan's Heroes
Solution: [Hogan's Heroes]


Question: News flash! This less-than-yappy pappy is sixth veep to be nation's top dog after chief takes deep sleep!
Query: 1920s NEWS FLASH! News flash! This less-than-yappy pappy is sixth veep to be nation's top dog after chief takes deep sleep!
Answer: TI MSP430
Solution: [Calvin Coolidge]


Question: In 2001: The president of the United States on television
Query: GOLDEN GLOBE WINNERS In 2001: The president of the United States on television
Answer: Geoffrey Rush
Solution: [Martin Sheen]


Question: 1989: "Miss You Much"
Query: '80s NO.1 HITMAKERS 1989: "Miss You Much"
Answer: I Love the '80s Strikes Back
Solution: [Janet Jackson]


Question: 1922: It's the end of an empire! This empire, in fact! After 600 years, it's goodbye, this, hello, Turkish Republic!
Query: 1920s NEWS FLASH! 1922: It's the end of an empire! This empire, in fact! After 600 years, it's goodbye, this, hello, Turkish Republic!
Answer: Mehmed VI
Solution: [Ottoman Empire]


Question: Crest toothpaste
Query: NAME THE PARENT COMPANY Crest toothpaste
Answer: Crest (toothpaste)
Solution: [Procter & Gamble]


Question: In 1888 this Chancellor told the Reichstag, "we Germans fear God, but nothing else in the world"
Query: HISTORICAL QUOTES In 1888 this Chancellor told the Reichstag, "we Germans fear God, but nothing else in the world"
Answer: Wilhelm II, German Emperor
Solution: [Otto von Bismarck, Von Bismarck]


Question: In 1787 he signed his first published poem "Axiologus"; axio- is from the Greek for "worth"
Query: POETS & POETRY In 1787 he signed his first published poem "Axiologus"; axio- is from the Greek for "worth"
Answer: Agis of Argos
Solution: [William Wordsworth]


Question: Not to be confused with karma, krama is a popular accessory sold in cambodia; the word means "scarf" in this national language of Cambodia
Query: CAMBODIAN HISTORY & CULTURE Not to be confused with karma, krama is a popular accessory sold in cambodia; the word means "scarf" in this national language of Cambodia
Answer: Politics of Cambodia
Solution: [Khmer language]


Question: Phnom Penh's notorious gridlock is circumvented by the nimble tuk-tuk, a motorized taxi that's also known as an auto this, a similar Asian conveyance.
Query: CAMBODIAN HISTORY & CULTURE Phnom Penh's notorious gridlock is circumvented by the nimble tuk-tuk, a motorized taxi that's also known as an auto this, a similar Asian conveyance.
Answer: Olympic Stadium (Phnom Penh)
Solution: [Rickshaw]


Question: 1980: "Rock With You"
Query: '80s NO.1 HITMAKERS 1980: "Rock With You"
Answer: A Flock of Seagulls
Solution: [Michael Jackson]


Question: The Pulitzer-winning "The Making of the President 1960" covered this man's successful presidential campaign
Query: NOTES FROM THE CAMPAIGN TRAIL The Pulitzer-winning "The Making of the President 1960" covered this man's successful presidential campaign
Answer: Michael Dukakis
Solution: [JFK, John F. Kennedy]


Question: In 1843 Isaac Dittenhoefer became the first pres. of this Jewish club whose name means "children of the covenant"
Query: SERVICE ORGANIZATIONS In 1843 Isaac Dittenhoefer became the first pres. of this Jewish club whose name means "children of the covenant"
Answer: B'nai B'rith
Solution: [B'nai B'rith]


Question: Don Knotts took over from Norman Fell as the resident landlord on this sitcom
Query: THE RESIDENTS Don Knotts took over from Norman Fell as the resident landlord on this sitcom
Answer: Don Knotts
Solution: [Three's Company]


Question: U.N. Res. 242 supports "secure and recognized boundaries" for Israel & neighbors following this June 1967 war
Query: OLD YEAR'S RESOLUTIONS U.N. Res. 242 supports "secure and recognized boundaries" for Israel & neighbors following this June 1967 war
Answer: Golan Heights
Solution: [The Six Day War]


Question: This blonde beauty who reprised her role as Amanda on the new "Melrose Place" was a psychology major
Query: UCLA CELEBRITY ALUMNI This blonde beauty who reprised her role as Amanda on the new "Melrose Place" was a psychology major
Answer: Heather Locklear
Solution: [Heather Locklear]


Question: The name of this dish of marinated lamb, skewered & grilled, comes from the Greek for "skewer" & also starts with "s"
Query: GREEK FOOD & DRINK The name of this dish of marinated lamb, skewered & grilled, comes from the Greek for "skewer" & also starts with "s"
Answer: Souvlaki
Solution: [Souvlaki]


Question: Post-it notes
Query: NAME THE PARENT COMPANY Post-it notes
Answer: US Airways Group
Solution: [3M]


Question: In 2010: As Sherlock Holmes on film
Query: GOLDEN GLOBE WINNERS In 2010: As Sherlock Holmes on film
Answer: I. A. L. Diamond
Solution: [Robert Downey, Jr.]
Total: 100
Correct: 30
Accuracy:30.0

Process finished with exit code 0
```