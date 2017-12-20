# Record Stores Backend

A simple search API for searching record store collections, currently for the Any Old Time record store in Amsterdam.

Consists of:
- A Spring Boot application providing an interface to query the record index
- [A Vue.js frontend](https://github.com/utwyko/recordstores-frontend)

## Any Old Time

Any Old Time stores it's collection in a txt file, found on their site. The backend parses this TXT files and stores it in memory.
