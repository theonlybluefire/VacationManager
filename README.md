# ℹ️ | Status
This project is currently in development

# ℹ️ | Concept
This is a vacation manager MVP.
The goal is you beeing able to input your leftover vacation days, the days you'll have to book vacation and the current holidays based on a preset you're able to set and the script will output the days you'll have to book. It should recognize weekends and holidays. 
A GUI will probably be added in another repo further down the line.

# ✅ | TODO 
- [x] (T0) Day class
- [ ] (T1) Build a LinkedList out of all days in the year with all necessary information to calculate the needed booking days
    - [ ] (T1.1) Implement calender object for a more standardised way of saving the data
    - [ ] (T1.2) create a Array for all months with 31 days (might be replaced by the calendar object)
    - [ ] (T1.3) create method for creating a new month
- [ ] (T2) Implement calculation
- [ ] (T3) Allow user input (ex. currentYear etc.)
- [ ] (T4) Preset system / Implement a method for saving and creating presets (ex. holidays)
- [ ] (T5) UI/create prompts for the system / show data accordingly

# 🐛 | Bugs during development
- [x]  (B1) Exception in thread "main" java.time.DateTimeException: Invalid date 'February 29' as '2025' is not a leap year : tries to get date from feb. 29th but 2025 is not a leap year. 
- [ ] (B2) Exception in thread "main" java.time.DateTimeException: Invalid value for MonthOfYear : Day object is created with a month of 13

