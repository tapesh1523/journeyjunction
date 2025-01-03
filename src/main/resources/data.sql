-- Step 1: Insert the Country "India"
INSERT INTO country (id, name, description)
VALUES (1, 'India', 'Country located in South Asia, known for its diversity and rich culture.');


-- Step 2: Insert 20 States for India
INSERT INTO state (id, name, description, country_id)
VALUES
    (1, 'Andhra Pradesh', 'State in the southeastern coastal region of India', 1),
    (2, 'Arunachal Pradesh', 'State in the northeastern part of India', 1),
    (3, 'Assam', 'State in northeastern India, known for tea and wildlife', 1),
    (4, 'Bihar', 'State in eastern India known for its history and culture', 1),
    (5, 'Chhattisgarh', 'State in central India, known for its forests and tribes', 1),
    (6, 'Goa', 'State in western India, known for beaches and tourism', 1),
    (7, 'Gujarat', 'State in western India, famous for its culture and cuisine', 1),
    (8, 'Haryana', 'State in northern India, known for agriculture and industry', 1),
    (9, 'Himachal Pradesh', 'State in northern India, famous for its hill stations', 1),
    (10, 'Jharkhand', 'State in eastern India known for its rich mineral resources', 1),
    (11, 'Karnataka', 'State in southern India, famous for its IT hub', 1),
    (12, 'Kerala', 'State in southern India, known for its beaches and backwaters', 1),
    (13, 'Madhya Pradesh', 'State in central India, known for history and heritage', 1),
    (14, 'Maharashtra', 'State in western India, known for Mumbai and its culture', 1),
    (15, 'Manipur', 'State in northeastern India, known for its natural beauty', 1),
    (16, 'Meghalaya', 'State in northeastern India, famous for its hills and rainfall', 1),
    (17, 'Mizoram', 'State in northeastern India, known for its natural beauty and culture', 1),
    (18, 'Nagaland', 'State in northeastern India, known for its tribes and culture', 1),
    (19, 'Odisha', 'State in eastern India, famous for its temples and beaches', 1),
    (20, 'Punjab', 'State in northern India, known for its agricultural significance', 1),
    (21, 'Rajasthan', 'State in the northwestern part of India, famous for its deserts, palaces, and rich history', 1);

-- Insert Cities for Andhra Pradesh (first 10 cities)
INSERT INTO city (id, name, description, state_id, crowded_month, time_to_visit, airport, railway_station, bus_station, duration, location)
VALUES
    (1, 'Visakhapatnam', 'Port city and industrial hub', 1, 'December', 'October-March', 'Visakhapatnam Airport', 'Visakhapatnam Railway Station', 'Visakhapatnam Bus Station', '3 hours', ST_GeomFromText('POINT(83.2185 17.6869)', 4326)),
    (2, 'Vijayawada', 'Business and cultural center', 1, 'November', 'November-February', 'Vijayawada Airport', 'Vijayawada Railway Station', 'Vijayawada Bus Station', '2 hours', ST_GeomFromText('POINT(80.7872 16.5063)', 4326)),
    (3, 'Tirupati', 'Temple town famous for the Tirumala Temple', 1, 'August', 'November-January', 'Tirupati Airport', 'Tirupati Railway Station', 'Tirupati Bus Station', '1.5 hours', ST_GeomFromText('POINT(79.4192 13.6288)', 4326)),
    (4, 'Guntur', 'Known for agriculture and education', 1, 'January', 'October-March', 'Guntur Airport', 'Guntur Railway Station', 'Guntur Bus Station', '1 hour', ST_GeomFromText('POINT(80.4366 16.3064)', 4326)),
    (5, 'Kakinada', 'Port city in Andhra Pradesh', 1, 'September', 'October-February', 'Kakinada Airport', 'Kakinada Railway Station', 'Kakinada Bus Station', '1.5 hours', ST_GeomFromText('POINT(82.2401 16.9918)', 4326)),
    (6, 'Nellore', 'Known for its temples and beaches', 1, 'May', 'October-February', 'Nellore Airport', 'Nellore Railway Station', 'Nellore Bus Station', '1 hour', ST_GeomFromText('POINT(79.9867 14.4427)', 4326)),
    (7, 'Rajahmundry', 'City on the banks of the Godavari River', 1, 'March', 'November-March', 'Rajahmundry Airport', 'Rajahmundry Railway Station', 'Rajahmundry Bus Station', '2 hours', ST_GeomFromText('POINT(81.7835 17.0041)', 4326)),
    (8, 'Chittoor', 'Famous for its temples and red sanders', 1, 'June', 'October-February', 'Chittoor Airport', 'Chittoor Railway Station', 'Chittoor Bus Station', '1.5 hours', ST_GeomFromText('POINT(79.1004 13.2003)', 4326)),
    (9, 'Anantapur', 'Known for agriculture and history', 1, 'April', 'October-February', 'Anantapur Airport', 'Anantapur Railway Station', 'Anantapur Bus Station', '1 hour', ST_GeomFromText('POINT(77.5996 14.6816)', 4326)),
    (10, 'Khammam', 'Known for its temples and industries', 1, 'July', 'November-February', 'Khammam Airport', 'Khammam Railway Station', 'Khammam Bus Station', '1.5 hours', ST_GeomFromText('POINT(80.1508 17.2474)', 4326));


-- Insert Cities for Rajasthan (first 10 cities)
INSERT INTO city (id, name, description, state_id, crowded_month, time_to_visit, airport, railway_station, bus_station, duration, location)
VALUES
    (11, 'Jaipur', 'Capital of Rajasthan, known for its palaces and forts', 21, 'October', 'October-March', 'Jaipur International Airport', 'Jaipur Railway Station', 'Jaipur Bus Station', '4 hours', ST_GeomFromText('POINT(75.8120 26.9124)', 4326)),
    (12, 'Udaipur', 'City of lakes, famous for its palaces and scenic beauty', 21, 'December', 'October-March', 'Maharana Pratap Airport', 'Udaipur Railway Station', 'Udaipur Bus Station', '3.5 hours', ST_GeomFromText('POINT(73.6780 24.5854)', 4326)),
    (13, 'Jodhpur', 'Known for its blue buildings and Mehrangarh Fort', 21, 'March', 'October-March', 'Jodhpur Airport', 'Jodhpur Railway Station', 'Jodhpur Bus Station', '2.5 hours', ST_GeomFromText('POINT(73.0243 26.2389)', 4326)),
    (14, 'Jaisalmer', 'Famous for its golden fort and desert landscape', 21, 'January', 'October-March', 'Jaisalmer Airport', 'Jaisalmer Railway Station', 'Jaisalmer Bus Station', '3 hours', ST_GeomFromText('POINT(70.9202 26.9124)', 4326)),
    (15, 'Bikaner', 'Known for its camel festival and Junagarh Fort', 21, 'February', 'November-February', 'Bikaner Airport', 'Bikaner Railway Station', 'Bikaner Bus Station', '2.5 hours', ST_GeomFromText('POINT(73.3021 28.0229)', 4326)),
    (16, 'Pushkar', 'Famous for its camel fair and Brahma Temple', 21, 'November', 'October-March', 'Ajmer Airport', 'Ajmer Railway Station', 'Pushkar Bus Station', '1 hour', ST_GeomFromText('POINT(74.5521 26.4930)', 4326)),
    (17, 'Ajmer', 'Known for the Ajmer Sharif Dargah', 21, 'September', 'October-March', 'Ajmer Airport', 'Ajmer Railway Station', 'Ajmer Bus Station', '2 hours', ST_GeomFromText('POINT(74.6399 26.4526)', 4326)),
    (18, 'Alwar', 'Known for its wildlife and heritage sites', 21, 'July', 'October-March', 'Indira Gandhi International Airport (Delhi)', 'Alwar Railway Station', 'Alwar Bus Station', '1.5 hours', ST_GeomFromText('POINT(76.6112 27.5574)', 4326)),
    (19, 'Sikar', 'Famous for its historical and architectural heritage', 21, 'April', 'November-February', 'Jaipur International Airport', 'Sikar Railway Station', 'Sikar Bus Station', '2 hours', ST_GeomFromText('POINT(75.5332 27.6167)', 4326)),
    (20, 'Kota', 'Known for its educational institutions and Chambal River', 21, 'June', 'October-February', 'Kota Airport', 'Kota Railway Station', 'Kota Bus Station', '1.5 hours', ST_GeomFromText('POINT(75.8198 25.2138)', 4326));

-- Inserting Attraction Types
INSERT INTO attraction_type (id, name) VALUES
                                           (1, 'Historical Monument'),
                                           (2, 'Cultural Site'),
                                           (3, 'Temple'),
                                           (4, 'Museum'),
                                           (5, 'Fort'),
                                           (6, 'Park'),
                                           (7, 'Shopping Area'),
                                           (8, 'Lake'),
                                           (9, 'Garden'),
                                           (10, 'Religious Site');


-- Inserting SuitableFor Categories
INSERT INTO suitable_for (id, name) VALUES
                                        (1, 'Families'),
                                        (2, 'Solo Travelers'),
                                        (3, 'Couples'),
                                        (4, 'Group Tours'),
                                        (5, 'Children'),
                                        (6, 'Senior Citizens'),
                                        (7, 'Adventure Seekers'),
                                        (8, 'History Enthusiasts');

-- Inserting 10 Famous Places in Jaipur with suitableFor and attractionType
INSERT INTO place (id, name, address, description, city_id, duration, visit_fare, rating, alert, booking_process_desc, location)
VALUES
    (1, 'Amber Fort', 'Amer, Jaipur, Rajasthan, India', 'A historic hilltop fort with stunning architecture and views of the surrounding countryside.', 11, '3 hours', 500, 4.7, 'None', 'Advance Booking Recommended', ST_GeomFromText('POINT(75.8515 26.9858)', 4326)),
    (2, 'City Palace', 'City Palace Complex, Jaipur, Rajasthan, India', 'A grand palace complex with museums, courtyards, and gardens, showcasing Rajasthani and Mughal architecture.', 11, '2 hours', 300, 4.6, 'None', 'Online Booking Available', ST_GeomFromText('POINT(75.8241 26.9196)', 4326)),
    (3, 'Hawa Mahal', 'Hawa Mahal Rd, Badi Choupad, Jaipur, Rajasthan, India', 'Known as the “Palace of Winds,” this beautiful five-story palace is famous for its intricate façade.', 11, '1 hour', 200, 4.5, 'None', 'No Booking Required', ST_GeomFromText('POINT(75.8505 26.9237)', 4326)),
    (4, 'Jantar Mantar', 'Jantar Mantar, Jaipur, Rajasthan, India', 'An astronomical observatory built in the 18th century, featuring massive instruments to measure time and celestial bodies.', 11, '1 hour', 150, 4.4, 'None', 'Ticket Available on Site', ST_GeomFromText('POINT(75.8578 26.9234)', 4326)),
    (5, 'Nahargarh Fort', 'Nahargarh Fort, Jaipur, Rajasthan, India', 'A fort offering panoramic views of Jaipur, known for its historic architecture and romantic ambiance.', 11, '2 hours', 200, 4.5, 'None', 'Advance Booking Available', ST_GeomFromText('POINT(75.7780 26.9852)', 4326)),
    (6, 'Jaigarh Fort', 'Jaigarh Fort, Jaipur, Rajasthan, India', 'A historic fort overlooking Jaipur, known for its massive walls and the world’s largest cannon on wheels.', 11, '2 hours', 250, 4.6, 'None', 'Booking Available on Site', ST_GeomFromText('POINT(75.7466 26.9855)', 4326)),
    (7, 'Albert Hall Museum', 'Albert Hall Museum, Ram Niwas Garden, Jaipur, Rajasthan, India', 'The oldest museum in Rajasthan, displaying a rich collection of art, artifacts, and sculptures.', 11, '2 hours', 100, 4.4, 'None', 'Ticket Available on Site', ST_GeomFromText('POINT(75.8254 26.9256)', 4326)),
    (8, 'Birla Mandir', 'Birla Mandir, Jaipur, Rajasthan, India', 'A modern Hindu temple built with white marble, dedicated to Lord Vishnu and Goddess Lakshmi.', 11, '1 hour', 0, 4.4, 'None', 'No Booking Required', ST_GeomFromText('POINT(75.8223 26.9144)', 4326)),
    (9, 'Sisodia Rani Garden', 'Sisodia Rani Garden, Jaipur, Rajasthan, India', 'A historical garden with beautiful water features, pavilions, and scenic surroundings, known for its Mughal and Rajput-style design.', 11, '1.5 hours', 100, 4.2, 'None', 'No Booking Required', ST_GeomFromText('POINT(75.8192 26.9095)', 4326)),
    (10, 'Panch Mahal', 'Fatehpur Sikri, near Jaipur, Rajasthan, India', 'A five-story palace with stunning architecture and panoramic views, once a place of leisure for the royal family.', 11, '1 hour', 150, 4.3, 'None', 'Ticket Available on Site', ST_GeomFromText('POINT(77.6030 27.0902)', 4326));

-- Associating suitableFor categories (e.g., Families, Solo Travelers, History Enthusiasts) and attractionType categories (e.g., Historical Monument, Museum, Temple)

-- Associating attraction types and suitable categories with place IDs
-- For Amber Fort (ID = 1)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (1, 1),  -- Historical Monument
                                                           (1, 5);  -- Fort
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (1, 1),  -- Families
                                                       (1, 7),  -- Adventure Seekers
                                                       (1, 8);  -- History Enthusiasts

-- For City Palace (ID = 2)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (2, 1),  -- Historical Monument
                                                           (2, 2),  -- Cultural Site
                                                           (2, 5);  -- Fort
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (2, 1),  -- Families
                                                       (2, 3),  -- Couples
                                                       (2, 8);  -- History Enthusiasts

-- For Hawa Mahal (ID = 3)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (3, 1),  -- Historical Monument
                                                           (3, 2);  -- Cultural Site
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (3, 2),  -- Solo Travelers
                                                       (3, 5),  -- Children
                                                       (3, 8);  -- History Enthusiasts

-- For Jantar Mantar (ID = 4)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (4, 4),  -- Museum
                                                           (4, 1);  -- Historical Monument
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (4, 8),  -- History Enthusiasts
                                                       (4, 2),  -- Solo Travelers
                                                       (4, 4);  -- Group Tours

-- For Nahargarh Fort (ID = 5)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (5, 5),  -- Fort
                                                           (5, 6);  -- Park
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (5, 3),  -- Couples
                                                       (5, 7),  -- Adventure Seekers
                                                       (5, 8);  -- History Enthusiasts

-- For Jaigarh Fort (ID = 6)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (6, 5),  -- Fort
                                                           (6, 1);  -- Historical Monument
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (6, 1),  -- Families
                                                       (6, 7),  -- Adventure Seekers
                                                       (6, 8);  -- History Enthusiasts

-- For Albert Hall Museum (ID = 7)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (7, 4),  -- Museum
                                                           (7, 2);  -- Cultural Site
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (7, 2),  -- Solo Travelers
                                                       (7, 3),  -- Couples
                                                       (7, 8);  -- History Enthusiasts

-- For Birla Mandir (ID = 8)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (8, 3),  -- Temple
                                                           (8, 2);  -- Cultural Site
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (8, 3),  -- Couples
                                                       (8, 1),  -- Families
                                                       (8, 6);  -- Senior Citizens

-- For Sisodia Rani Garden (ID = 9)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (9, 6),  -- Park
                                                           (9, 9);  -- Garden
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (9, 1),  -- Families
                                                       (9, 5),  -- Children
                                                       (9, 4);  -- Group Tours

-- For Panch Mahal (ID = 10)
INSERT INTO place_attraction (place_id, attraction_id) VALUES
                                                           (10, 1),  -- Historical Monument
                                                           (10, 5);  -- Fort
INSERT INTO place_suitable (place_id, suitable_id) VALUES
                                                       (10, 8),  -- History Enthusiasts
                                                       (10, 2),  -- Solo Travelers
                                                       (10, 7);  -- Adventure Seekers

