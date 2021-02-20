-- 0
SELECT * FROM orszagok
ORDER BY 1;

--     1.  Mi MADAGASZKÁR fővárosa?
SELECT forvaros FROM orszagok WHERE orszag="MADAGASZKÁR";

--       2.  Melyik ország fővárosa OUAGADOUGOU?
SELECT orszag FROM orszagok WHERE forvaros= "OUAGADOUGOU";

--       3.  Melyik ország autójele a TT?
SELECT orszag FROM orszagok WHERE autojel = "TT";

--       4.  Melyik ország pénzének jele az SGD?
SELECT orszag FROM orszagok WHERE penzjel = "SGD";

--       5.  Melyik ország nemzetközi telefon-hívószáma a 61?
SELECT orszag FROM orszagok WHERE telefon = "61";

--       6.  Mekkora területű Monaco?
SELECT terulet FROM orszagok WHERE orszag = "MONACO";

--       7.  Hányan laknak Máltán?
SELECT nepesseg FROM orszagok WHERE orszag = "MÁLTA";

--       8.  Mennyi Japán népsűrűsége?
SELECT nepesseg*1000/terulet FROM orszagok WHERE orszag = "JAPÁN";

--       9.  Mely országok népsűrűsége nagyobb 500 fő/km2-nél?
SELECT orszag FROM orszagok WHERE nepesseg*1000/terulet >500;

--      10.  Melyek a szigetországok?
SELECT orszag FROM orszagok WHERE foldr_hely LIKE "%szigetország%";

--      11.  Melyik a első hat legnagyobb területű ország?
SELECT orszag FROM orszagok ORDER BY terulet DESC LIMIT 6;

--      12.  Melyik három ország területe a legkisebb?
SELECT orszag FROM orszagok ORDER BY terulet LIMIT 3;
