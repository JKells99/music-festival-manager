# Music Festival Manager
## Application Project Outline

**Project Type:** Full-stack web application  
**Primary Users:** Festival administrators  
**Future Users:** Students, music teachers, adjudicators and volunteers  
**Architecture:** Modular monolith  
**Database:** PostgreSQL  
**Backend:** Go or Java Spring Boot

---

# 1. Project Overview

Music Festival Manager is a web-based application designed to help a community organization manage and coordinate its annual competitive music festival.

The application will centralize festival administration, including competitor registration, class management, music selections, adjudicator assignments, volunteer coordination, venue management and scheduling.

Initially, the application will be used exclusively by the festival's administrative team.

The longer-term goal is to introduce a participant-facing portal where students and teachers can create accounts, register for classes and view their festival schedules.

The application must support multiple annual editions of the same festival while maintaining historical information from previous years.

# 2. Project Goals

The primary goals are to:

- Replace manual and disconnected festival administration processes.
- Maintain centralized records of competitors, teachers and festival personnel.
- Manage classes and competitor registrations.
- Track the music pieces being performed.
- Coordinate adjudicators and volunteers.
- Schedule classes across multiple festival days and venues.
- Provide administrators with an overview of festival operations.
- Eventually allow students and teachers to interact directly with the system.

# 3. Core Domain Concepts

## 3.1 Organization

Represents the community organization responsible for hosting the music festival.

An organization can host multiple annual festival editions.

## 3.2 Festival Edition

Represents one specific year's festival.

Each edition belongs to one organization and takes place in one town.

**Attributes:**
- Festival ID
- Organization ID
- Name
- Year
- Town
- Start date
- End date
- Status

Each annual edition maintains its own classes, registrations, schedules, assignments and results.

Previous editions should remain accessible for historical reference.

## 3.3 Classes

Classes represent the competitive categories offered during a festival.

Each class has exactly two identifying attributes:

- Class number
- Class name

Examples:

| Class Number | Class Name |
|---|---|
| 101 | Piano Solo - Beginner |
| 102 | Piano Solo - Intermediate |
| 103 | Piano Solo - Advanced |
| 201 | Violin Solo - Beginner |
| 202 | Violin Solo - Intermediate |

Classes belong to a specific festival edition.

A class has:
- Multiple competitors.
- One adjudicator.
- Multiple volunteers.
- One scheduled time.
- One assigned venue.

Class numbers must be unique within a festival edition.

## 3.4 Competitors

Competitors are students participating in the music festival.

**Attributes:**
- Competitor ID
- First name
- Last name
- Email
- Phone number
- Optional music teacher

A competitor can participate in multiple classes.

A competitor should have one registration per class within a festival edition.

Competitor records should be reusable across annual editions.

## 3.5 Music Teachers

Music teachers are individuals who provide music instruction to competitors.

**Attributes:**
- Teacher ID
- First name
- Last name
- Email
- Phone number

A teacher can be associated with multiple students.

A competitor may have one music teacher or be self-taught.

The teacher relationship is optional.

## 3.6 Class Entries / Registrations

A class entry represents one competitor's participation in a particular class.

This is an important entity because it connects competitors, classes and music selections.

**Attributes:**
- Entry ID
- Competitor ID
- Class ID
- Registration date
- Registration status

Business rules:
- A competitor can enter multiple classes.
- A competitor cannot enter the same class twice in one festival edition.
- Each class entry must have exactly one music piece.

## 3.7 Music Pieces

Each class entry has one music piece associated with it.

**Attributes:**
- Music Piece ID
- Title
- Composer
- Arranger (optional)

Different competitors may perform the same music piece.

A competitor may perform different pieces in different classes.

## 3.8 Adjudicators

Adjudicators evaluate competitor performances.

**Attributes:**
- Adjudicator ID
- First name
- Last name
- Email
- Phone number

For the initial version, each class is assigned one adjudicator.

Future functionality may include recording adjudicator comments, marks and awards.

## 3.9 Volunteers

Volunteers assist with festival operations.

**Attributes:**
- Volunteer ID
- First name
- Last name
- Email
- Phone number

Volunteers can be assigned to multiple classes.

Each class can have multiple volunteers.

## 3.10 Venues

Venues represent the physical locations where classes take place.

**Attributes:**
- Venue ID
- Name
- Address
- Capacity (optional)

Venues belong to a festival edition or can be maintained as reusable organization records.

## 3.11 Class Schedule

Scheduling is maintained separately from the class definition.

Each class has one scheduled occurrence.

**Attributes:**
- Schedule ID
- Class ID
- Festival date
- Start time
- End time
- Venue ID

A festival can have multiple classes running on the same day at different venues.

The application should identify scheduling conflicts, including:
- Overlapping classes at the same venue.
- Overlapping assignments for adjudicators.
- Overlapping volunteer assignments.

# 4. Application Modules

## 4.1 Administrative Dashboard

The main landing page for festival administrators.

Features:
- Festival year selection.
- Total competitor count.
- Total class count.
- Total volunteer count.
- Total venue count.
- Today's scheduled classes.
- Upcoming classes.
- Unassigned adjudicators.
- Missing music selections.
- Scheduling warnings.

## 4.2 Festival Management

Features:
- Create annual festival editions.
- Edit festival information.
- Select the festival town.
- Set festival dates.
- View previous editions.
- Switch between festival years.

## 4.3 Class Management

Features:
- Create classes.
- Assign class numbers.
- Assign class names.
- Edit class information.
- View registered competitors.
- Assign adjudicators.
- Assign volunteers.
- View class schedules.

## 4.4 Competitor Management

Features:
- Create competitor profiles.
- Edit competitor information.
- Associate competitors with music teachers.
- Mark competitors as self-taught through the absence of a teacher association.
- View class registrations.
- View music selections.
- View historical festival participation.

## 4.5 Teacher Management

Features:
- Create teacher profiles.
- Edit teacher information.
- Associate students with teachers.
- View associated competitors.

## 4.6 Music Management

Features:
- Record music pieces.
- Store titles, composers and arrangers.
- Associate music pieces with class entries.
- Review missing music selections.

## 4.7 Adjudicator Management

Features:
- Create adjudicator profiles.
- Assign adjudicators to classes.
- View assigned classes.
- Identify scheduling conflicts.

## 4.8 Volunteer Management

Features:
- Create volunteer profiles.
- Assign volunteers to classes.
- View volunteer assignments.
- Identify scheduling conflicts.

## 4.9 Venue Management

Features:
- Create venues.
- Edit venue information.
- Store addresses and capacities.
- Associate venues with scheduled classes.

## 4.10 Scheduling

Features:
- Schedule classes by festival date.
- Assign start and end times.
- Assign venues.
- View schedules by day.
- View schedules by venue.
- Detect scheduling conflicts.

## 4.11 Reporting

Future functionality:
- Competitor lists by class.
- Class schedules.
- Adjudicator assignments.
- Volunteer assignments.
- Festival programs.
- Participation statistics.
- Printable reports.

# 5. Future Participant Portal

The architecture should support a future participant-facing experience.

This will be introduced after the administrative application is functional.

### Student Accounts

Students should eventually be able to:

- Create an account.
- Maintain their competitor profile.
- Associate with a music teacher.
- Browse available classes.
- Register for classes.
- Submit music selections.
- View their registered classes.
- View their personal festival schedule.

### Teacher Accounts

Teachers should eventually be able to:

- Create an account.
- Maintain their teacher profile.
- Associate with students.
- View associated students.
- View student registrations.
- View student festival schedules.

### Additional Roles

Future account types may include:

- Administrator
- Student
- Teacher
- Adjudicator
- Volunteer

Authentication and authorization should be designed to accommodate these roles from the beginning, even if only administrators can log in initially.

# 6. Suggested Data Relationships

| Relationship | Cardinality |
|---|---|
| Organization → Festival | One-to-many |
| Festival → Classes | One-to-many |
| Festival → Venues | One-to-many |
| Class → Class Entry | One-to-many |
| Competitor → Class Entry | One-to-many |
| Class Entry → Music Piece | One-to-one |
| Teacher → Competitors | One-to-many |
| Adjudicator → Classes | One-to-many |
| Class → Schedule | One-to-one |
| Venue → Schedules | One-to-many |
| Class → Volunteers | Many-to-many |

# 7. Technical Architecture

The application should initially use a modular monolithic architecture.

This means one backend application with clearly separated business modules.

Suggested modules:

- Festival
- Organization
- Class
- Competitor
- Teacher
- Music
- Registration
- Adjudicator
- Volunteer
- Venue
- Scheduling
- Authentication
- Reporting

The backend will expose a REST API consumed by the frontend.

PostgreSQL will be the primary persistence layer.

The application should be containerized using Docker and deployed to a hosting environment.

# 8. Technology Options

Two backend technologies are being considered.

### Option A: Go

Suggested technologies:

- Go
- Chi or Gin for HTTP routing
- PostgreSQL
- pgx and sqlc for database access
- golang-migrate for database migrations
- React and TypeScript for the frontend
- Docker for deployment

Advantages:
- Lightweight deployment.
- Strong typing.
- Excellent performance.
- Explicit application structure.
- Good standard library.
- Relatively small runtime footprint.

### Option B: Java Spring Boot

Suggested technologies:

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- PostgreSQL
- Flyway for database migrations
- React and TypeScript for the frontend
- Docker for deployment

Advantages:
- Comprehensive application framework.
- Mature security ecosystem.
- Strong ORM and database integration.
- Excellent validation and testing support.
- Well-established enterprise development patterns.

### Architectural Recommendation

Both options are appropriate.

Start with a modular monolith rather than microservices.

The choice should primarily depend on development preferences and learning objectives, not performance requirements.

# 9. Development Roadmap

## Phase 1: Project Foundation
- Initialize repository.
- Configure backend and frontend.
- Configure PostgreSQL.
- Establish database migrations.
- Set up Docker.
- Implement administrator authentication.
- Implement organization and festival management.

## Phase 2: Core Festival Data
- Implement competitor management.
- Implement teacher management.
- Implement adjudicator management.
- Implement volunteer management.
- Implement venue management.

## Phase 3: Classes and Registrations
- Implement class management.
- Implement class entries.
- Implement music piece management.
- Establish registration constraints.
- Connect competitors to classes.

## Phase 4: Scheduling
- Implement class scheduling.
- Assign venues.
- Assign adjudicators and volunteers.
- Implement conflict detection.
- Build schedule views.

## Phase 5: Administrative Dashboard
- Build dashboard statistics.
- Display upcoming classes.
- Display daily schedules.
- Display outstanding administrative tasks.
- Implement reporting.

## Phase 6: Participant Portal
- Introduce student accounts.
- Introduce teacher accounts.
- Implement public class listings.
- Implement student registration.
- Implement personal schedules.
- Implement teacher/student associations.

## Phase 7: Advanced Festival Features
- Adjudication comments and marks.
- Awards and certificates.
- Printable festival programs.
- Email notifications.
- Advanced reporting.

# 10. Initial MVP Scope

The first release should focus exclusively on festival administration.

The MVP is considered complete when an administrator can:

1. Create an annual festival edition.
2. Manage competitors and teachers.
3. Create and manage classes.
4. Register competitors in classes.
5. Record music selections.
6. Manage adjudicators and volunteers.
7. Manage venues.
8. Schedule classes across festival days.
9. Identify scheduling conflicts.
10. View the complete festival schedule.
11. Switch between annual festival editions.

The participant portal, adjudication system and advanced reporting should remain outside the initial MVP.

---

# 11. Important Design Principles

- Keep annual festival editions independent.
- Reuse people and venue information where appropriate.
- Keep class definitions minimal: class number and name only.
- Separate class definitions from scheduling.
- Use database constraints to enforce important business rules.
- Keep authentication separate from participant profiles.
- Design role-based permissions early.
- Avoid unnecessary architectural complexity.
- Prioritize maintainability and data integrity.
- Preserve historical festival information.

**Overall Vision:** Build a reliable, maintainable festival management platform that starts as an administrative tool and gradually evolves into a complete digital platform for organizing and participating in a community music festival.
