# Frequent Flyer System
The feature allows a user to see their current miles balance, and use their miles.

It allows flyer to transfer miles from their account to someone else’s account. This functionality is implemented in method transferMiles(Deposit deposit), that takes a Deposit as an input argument.

Deposit consists of amount that is in the range [1000 – 10000] miles, information about the recipient’s unique account ID, and their name.

For security and privacy reasons, the method checks that the provided information about a recipient corresponds to one of the existing customers, and that the provided ID matches recipient’s name.