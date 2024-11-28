INSERT INTO employees (first_name, last_name, email, department, title, password)
VALUES
('John', 'Smith', 'john.smith@example.com', 'Marketing', 'Marketing Manager', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Jane', 'Doe', 'jane.doe@example.com', 'Sales', 'Sales Executive', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Robert', 'Brown', 'robert.brown@example.com', 'IT', 'Systems Analyst', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Emily', 'Davis', 'emily.davis@example.com', 'HR', 'HR Specialist', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Michael', 'Wilson', 'michael.wilson@example.com', 'Finance', 'Accountant', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Sarah', 'Taylor', 'sarah.taylor@example.com', 'Customer Support', 'Support Lead', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('David', 'Moore', 'david.moore@example.com', 'Development', 'Software Engineer', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Jessica', 'Lee', 'jessica.lee@example.com', 'Legal', 'Legal Advisor', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Daniel', 'Harris', 'daniel.harris@example.com', 'Operations', 'Operations Manager', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y'),
('Laura', 'Clark', 'laura.clark@example.com', 'Procurement', 'Procurement Specialist', '$2a$10$6w28uHliFBVU8HchlV0JY.VqMY1FyUpIUtpSVt2cyGBLDJXluwT/y');

INSERT INTO courses (course_code, course_name, emp_id)
VALUES
('CS101', 'Introduction to Computer Science', 1),
('MATH201', 'Calculus I', 1),
('ENG150', 'English Literature', 1),
('PHYS101', 'Physics Fundamentals', 2),
('HIST210', 'World History', 2),
('BIO110', 'Principles of Biology', 2),
('CHEM101', 'General Chemistry', 3),
('PSYCH101', 'Introduction to Psychology', 3),
('ECON201', 'Microeconomics', 4),
('ART101', 'Basics of Drawing', 4);

INSERT INTO students (roll_no, first_name, last_name, email)
VALUES
('S001', 'Alice', 'Johnson', 'alice.johnson@example.com'),
('S002', 'Bob', 'Smith', 'bob.smith@example.com'),
('S003', 'Charlie', 'Brown', 'charlie.brown@example.com'),
('S004', 'Diana', 'Miller', 'diana.miller@example.com'),
('S005', 'Ethan', 'Davis', 'ethan.davis@example.com'),
('S006', 'Fiona', 'Wilson', 'fiona.wilson@example.com'),
('S007', 'George', 'Clark', 'george.clark@example.com'),
('S008', 'Hannah', 'Lee', 'hannah.lee@example.com'),
('S009', 'Ian', 'Taylor', 'ian.taylor@example.com'),
('S010', 'Julia', 'Anderson', 'julia.anderson@example.com');