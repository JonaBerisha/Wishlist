INSERT INTO user (email, password, name, birth_date)
VALUES ('test@test.com', '1234', 'Test User', '2000-01-01');

INSERT INTO wishlist (name, user_id)
VALUES ('Min Ønskeliste', 1);

INSERT INTO items(name, price, link, image, wishlist_id)
VALUES ('Nokai', 400, 'https://www.elgiganten.dk/product/mobil-tablet-smartwatch/mobiltelefon/nokia-105-mobiltelefon-sort/903692?utm_source=google&utm_medium=cpc&utm_campaign=DK%20-%20Shopping%20-%20AO%20-%20TELE%20-%20Generic&utm_id=17542183096&gad_source=1&gad_campaignid=17542183096&gbraid=0AAAAAD-SSGAcoKJaYD2MQ29bUkqo3TCYg&gclid=CjwKCAjwnZfPBhAGEiwAzg-VzIbxnaiSGT0r6raJYfiosiTRGtpTltJCSxLwErJahEEtzqzgoqEDoBoCBdkQAvD_BwE', '',1);