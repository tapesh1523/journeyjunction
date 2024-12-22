-- -- Step 1: Insert the Country "India"
INSERT INTO country (id, name, description)
VALUES (1, 'India', 'Country located in South Asia, known for its diversity and rich culture.');

-- -- Step 2: Insert 20 States for India
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
    (20, 'Punjab', 'State in northern India, known for its agricultural significance', 1);

-- -- Step 3: Insert 10 Cities for each of the 20 States (for demo purposes, using the same set of city names and random data for cities)
--

-- -- -- Step 1: Insert Cities for Andhra Pradesh
-- --
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

-- Repeat for other states and cities...
