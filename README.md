Elindítani: 
java -jar skeletonTest.jar

1 Áttekintés
1.1 Általános áttekintés
Társasjáték szerű, körökre osztott többjátékosra szabott 2D-s program. A játékot egy
menüből lehet elindítani, ahol személyre tudja a felhasználó szabni a játékmenetet. A
játékosoknak az a feladata, hogy egy labirintusban megtalálják a mágikus erejű
logarlécet, miközben az oktatók próbálják ezt megakadályozni.
1.2 Funkciók
Indításkor először egy menü nézet jelenik meg, ahol a következőket lehet személyre
szabni: hány játékos játszik a következő menetben, és mi a nevük, ezt a felhasználók
saját maguk állíthatják be.
A játék során a labirintus felfedezett része látható a játékosok számára, ahol a
szobák egy gráf pontjai, az ajtók pedig az élek. A térképen csak az eddig felfedezett
szobák és azok közvetlen szomszédai láthatóak. Amikor egy játékos belép egy új
szobába, annak szomszédai automatikusan felfedezetté válnak, de azok tartalma
nem láthatóak addig amíg valaki be nem lép.
Ezek mellett képernyőn megjelenik hogy, melyik játékos van soron, az adott játékos
melyik szobában van és milyen tárgyai vannak. A szoba tulajdonságai ahol az
aktuális játékos tartózkodik az erre dedikált helyen látszódnak. Ilyen tulajdonság
lehet például a befogadóképesség. Ha egy szobában a létszám eléri a maximumot
akkor nem lehet oda bemenni.
A felhasználó egy körben eldöntheti, hogy milyen interakciókat használ, átmegy-e
egy szomszédos szobába és/vagy egy tárgyat használ/vesz fel. Mindenkinek fix
számú interakciója van, egy körben 3.
Ha a játékos olyan szobába lép ahol már van egy oktató, akkor automatikusan
megpróbálja ellopni a hallgató lelkét. Ha a játékosnál nincsen semmilyen tárgy amivel
meg tudná védeni magát, akkor kiesett a játékból, ellenkező esetben a játék
automatikusan választja ki, hogy melyiket használja a védekezésre. Ha egy
hallgatónak elvették a lelkét minden tárgyát eldobja a szobába, és kiesik a játékból.
Egy hallgatónál maximum 5 tárgy lehet. A tárgyakat felvehetik az oktatók is, így
megakadályozva azt hogy a hallgatók használni tudják azokat.
Tárgyak:
A tárgyak a szobákban véletlenszerűen generálódnak.
TVSZ denevérbőrre nyomtatott példányai: Három alkalommal mentik meg a hallgató
életét, utána kikerülnek a hallgató zsebéből, automatikusan aktiválódik.
Szent söröspoharak: Amennyiben felveszi a hallgató ezt a tárgyat, 3 kör erejéig
védelmet kap az oktatókkal szemben. Nedves táblatörlő rongy: Ha egy oktató olyan szobába lép ahol egy nedves táblatörlő
aktiválva van, megbénul és 1 körből kimarad. 5 kör után kiszárad, de egy oktatót
csak egy körig bénít meg.
Dobozolt káposztás camembert: Felbontása mérges gázt bocsát ki, ami a szobát
elgázosítja. Hallgatók és oktatók is ha ilyen szobába lépnek elkábulnak, körüknek
vége, és elejtik minden tárgyukat.
FFP2-es maszk: Ha egy olyan hallgató vagy oktató lép gázos szobába, akinél egy
FFP2-es maszk van, védelmet kap a gáz hatása ellen egy körig, utána a maszk
használhatatlan lesz, és megsemmisül azaz eltűnik a zsebből.
Tranzisztorok: A hallgatónál lévő tranzisztorokat páronként össze lehet kapcsolni,
egy interakció felhasználásával, majd a pár egyik tagját menet közben egy másik
szobában le lehet tenni(1. aktiválás). Az így összekapcsolt tranzisztorok varázserővel
bírnak: ha a hallgató a nála maradó tranzisztort bekapcsolja és leteszi(2.aktiválás),
akkor a másik tranzisztor szobájába kerül, a bekapcsolt tranzisztor pedig kikapcsol
és a szobában marad, ahol egy másik játékos felveheti. A tranzisztorok korlátlan
ideig használhatók.
Szobák típusai:
Gázos: a gázos szobába belépve a játékos elejti a nála lévő tárgyakat és a köre
véget ér. Ha oktató lép a gázos szobába akkor abban a körben senkit nem tud
megölni. Ő is elejti a nála lévő tárgyakat és a köre véget ér.
Elátkozott szoba: Az ajtajai véletlenszerűen egy új kör elején eltűnhetnek, és ugyan
ilyen gyakorisággal vissza is kerülhetnek.
A szobák képesek egyesülni és osztódni. Két szomszédos szoba egyesülésével
létrejött szoba a korábbi két szoba tulajdonságaival és szomszédaival rendelkezik,
de a befogadóképessége a nagyobb szoba befogadóképességével lesz azonos. Az
osztódó szoba két olyan szobára válik szét, amelyek egymás szomszédai lesznek,
és megosztoznak a korábbi szoba képességein és szomszédain (a korábbi
szomszédok vagy csak az egyik, vagy csak a másik “új” szobának lesznek
szomszédai).
Miután minden játékos lépett a pálya változása következik be, szobák egyesülése,
osztódása, ajtók eltűnése vagy megjelenése. Csak olyan szobák
transzformálódhatnak amelyekben nincsen se hallgató se oktató.
Az oktatók mozgása: Egy oktatónak egy körben kettő interakciója van, maximum 5
tárgyat birtokolhat, viszont használni nem tudja őket. (kivéve az FFP2-es maszk,
mert az az oktatóknak is védelmet biztosít) Amikor belép egy szobába ahol van
szabad tárgy akkor azokból egyet felvesz és elrak. Ha nem tudna új tárgyat felvenni,
mert megtelt a zsebe, a legrégebben felvett tárgyat eldobja a szobában, amit később
egy hallgató, vagy egy másik oktató felvehet.
A játéknak addig tart amíg minden hallgató ki nem bukott az egyetemről, vagy
valamelyik hallgató magához nem vette a logarlécet.
1.3 Felhasználók
A felhasználók adott sorrendben, egymás után következve irányíthatják a játékot.
Maximum 5 játékos játszhat egyszerre egy számítógépen úgy, hogy egymásnak
adogatják át az egeret.
1.4 Korlátozások
A szoftvernek a kari felhőben biztosított virtuális gépen fordíthatónak, és
futtathatónak kell lennie, helyesen kell működnie és minden előre definiált funkcióját
teljesítenie kell.
