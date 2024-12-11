CREATE TABLE bus_schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    destination VARCHAR(255) NOT NULL,
    bus_number VARCHAR(50) NOT NULL,
    departure_time DATETIME NOT NULL,
    carrier VARCHAR(255) NOT NULL,
    trip_duration INT NOT NULL,
    license_plate VARCHAR(50) NOT NULL
);
