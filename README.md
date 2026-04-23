## 🧠 What I Built & Why

I built a simple full-stack car recommendation application that helps a user go from confusion to a clear shortlist. 

Instead of building a large search portal, I focused on a narrow and high-impact flow:
- User enters basic preferences (budget, fuel type, body type, priority)
- System returns a small set of recommended cars
- User can shortlist and compare options

The goal was to reduce decision fatigue and provide quick clarity rather than overwhelming the user with too many filters.

### What I deliberately cut
To stay within the 2–3 hour constraint, I intentionally avoided:
- Authentication (login/signup)
- Complex filtering (brand, location, etc.)
- Pagination and advanced UI states
- AI/ML-based recommendation models
- Admin dashboards or CRUD panels

I prioritized a working end-to-end experience over feature completeness.

---

## ⚙️ Tech Stack & Why

**Frontend:** React (Vite)  
- Fast to set up and lightweight  
- Good for building interactive UI quickly  

**Backend:** Spring Boot  
- Familiar stack → faster development  
- Strong for building REST APIs  
- Clean structure for scalability  

**Database:** MySQL  
- Simple relational model works well for structured car data  
- Easy integration with Spring Data JPA  

Overall, I chose tools I’m comfortable with so I could focus on shipping quickly rather than setup overhead.

---

## 🤖 AI Tool Usage

I used AI tools (Codex/ChatGPT) to accelerate development, especially for:
- Initial project scaffolding (Spring Boot + React structure)
- Generating boilerplate code (controllers, services, API calls)
- Debugging setup issues (JDK, MySQL, CORS, etc.)

### Where AI helped most
- Speeding up repetitive code generation
- Quickly setting up APIs and data models
- Resolving configuration issues

### What I did manually
- Deciding product scope and features
- Designing recommendation logic
- Fixing integration issues between frontend and backend
- Cleaning up and simplifying generated code

### Where AI struggled
- Sometimes overcomplicated simple logic
- Generated unnecessary structure for a small MVP
- Required manual correction to match my exact use case

---

## 🚀 If I Had 4 More Hours

If I had more time, I would improve both product experience and logic:

### Product improvements
- Add comparison view (side-by-side car comparison)
- Better UI/UX polish and responsiveness
- Add filters like brand, transmission, seating

### Backend improvements
- Smarter recommendation algorithm (weighted scoring + personalization)
- Caching frequently requested results
- Validation and better error handling

### AI enhancements
- Add a conversational assistant (chat-based car suggestion)
- Use user reviews to influence recommendations

---

## 🎯 Summary

The focus of this assignment was:
- Ship a working full-stack product quickly
- Make clear product decisions
- Use AI tools effectively without over-relying on them

I optimized for clarity, speed, and a usable end-to-end experience.