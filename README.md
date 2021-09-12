# COMP2240_A2.a - Threads & Semaphores. 

WARs are simple robots which repeatedly travel back and forth in the same track, being ‘Loaded’ in their trip from Storage to Dock and return ‘Unloaded’ in the return trip. 
Each WAR has a unique number for identification but its status changes between ‘Loaded’ and ‘Unloaded’ from trip to trip. 
After initial setup, it was immediately identified that WARs operating in both tracks can collide in the intersection, therefore, Daintree employed you to solve the problem. 
The assigned task is as follows:

1. The intersection can become deadlocked if two WARs from different directions enter the intersection (WARs can only go forward). 
Collison is evident if more than one WAR enter the intersection simultaneously. So, for safety purpose, not more than one WAR is allowed to enter the intersection.
2. The solution should be starvation free. I.e. a stream of WARs from any one direction should not prevent WARs from other directions to cross the intersection.
3. There are three checkpoints (sensors) in the intersection to which each WAR reports. Add 200 ms delay after each checkpoint to simulate the time to pass the checkpoint. The system keeps track of WARs passing in each track (i.e. counts every time a WAR in a track crosses the intersection).
4. Loading and unloading of goods happen instantly (i.e. the assumption is no time is required) after a WAR crosses the intersection.

Using semaphores, design and implement an algorithm that prevents deadlock. 
Use threads to simulate multiple/concurrent WARs and assume that the group of WARs are constantly attempting to use the intersection from all four directions (N, S, W, E). 
Your program should input parameters at runtime to initialise the number of WARs from each direction. 
For example, the input ”N=3 S=1 E=1 W=1” would indicate that the simulation should start with 3, 1, 1 and 1 WARS starting from north, south, east and west direction respectively. 
WARs should be numbered continuously starting from 1 (e.g. WAR-1, WAR-2 etc.) You may choose how to number the WARs but the total number of WARs from each direction (N, S, E, W) must match the input. 
Depending on whether a WAR is going towards the Dock or towards the Storage it will be “Loaded” or “Unloaded”, respectively.

Termination Criteria:
You will terminate your simulation once the Total crossed Track1 and Track2 have both reached 150.
