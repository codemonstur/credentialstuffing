
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

# Credential Stuffing

A command line tool for testing a known credential set (username and password) against a list of online services.

If there is a service that is not included please file an issue.

## Supported services

- Admiral
- AirAsia
- AmiAmi
- Anthem

I only just created this repo.
How did you get here?!

## Known security vulnerabilities

I took the services listed at https://dumbpasswordrules.com/ and tried to implement a few of them.

I can highly encourage anyone to take a look. And please don't use any of the listed services. 
Use services that know how to do security.

When you look at the login page of these sites you sometimes find additional mistakes in addition 
to their bad password policies.
These are some things I found:

- AirAsia claims to block accounts after a number of failed login attempts
- AirAsia leaks whether an account exists if it happens to be blocked
- AirAsia login form will tell you what the password requirements are
- AirFrance login form will tell you if an account exists
- ANZ accounts have a fixed format
- Apec will tell you if an account exists
- Ancestry will tell you what the password requirements are on the login page
- bbva locks accounts after 5 bad login attempts
