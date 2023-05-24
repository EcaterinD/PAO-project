# Proiect PAO - Food ordering

## Dîrțu Ecaterina, grupa 242

## - Etapa 1 -

### Clasele pe care le-am implementat in acest proiect sunt:  

1) **Cumparator**
2) **Comanda**
3) **Mancare** (mosteneste Comanda)
4) **Meniu** (mosteneste Mancare)
5) **Desert** (mosteneste Mancare)
6) **Bautura** (mosteneste Comanda)


7) **CumparatorService**
8) **MeniuService**
9) **DesertService**
10) **BauturaService**

### Cele 10 actiuni/interogari sunt urmatoarele:

Pentru toate modelele:
1) add 
2) get 
3) getAll 
4) update 
5) delete 

Specifice:
6) score (cumparator)
7) count +18 (cumparator)
8) price (meniu)
9) get by premium si cantitate minima data (meniu)
10) time until ready (bautura)


## - Etapa 2 -

### Clasele pe care le-am implementat in acest proiect sunt:

1) **Comanda**
2) **Cumparator**
3) **Produs**, clasa abstracta
4) **Mancare** (mosteneste Produs), clasa abstracta
5) **Meniu** (mosteneste Mancare)
6) **Desert** (mosteneste Mancare)
7) **Bautura** (mosteneste Produs)


8) **ComandaService**
9) **CumparatorService**
10) **MeniuService**
11) **DesertService**
12) **BauturaService**

### Cele 10 actiuni/interogari sunt urmatoarele:

Obs: 

V1 - pentru clasele Cumparator, Meniu, Desert, Bautura

V2 - pentru clasa Comanda ce contine obiecte din toate celelate clase ce pot fi instantiate

1) add V1 
2) add V2 
3) getAll V1
4) getAll V2 
5) getAll Comenzile unui Cumparator specificat 
6) getBy Int (pret pentru Bautura)
7) update Int (pretul produselor: Meniu, Desert, Bautura)
8) update String (emailul Cumparatorului)
9) deleteV1



