# COMP2240_A2.Problem-1 - Threads & Semaphores. 
Mark Receiced - 100%

TASK:
The newly established School of Information and Physical Sciences (SIPS) at UoN bought a new multi-printer that can print both in colour and in monochrome. The multi-printer has three printing heads which can print up to three jobs in parallel. We classify a job as either Monochrome (M) or Colour (C) based on its mode of printing. However, the printer can operate in either of its two modes (Monochrome or Colour) at a time. If a Monochrome job is currently printing in the printer then the other two vacant printing heads can be used for Monochrome printing only – a Colour printing job must wait. A printing job (Monochrome or Colour) must specify beforehand the number of pages it will be printing. So the assumptions in operating the multi-printer are:

• Monochrome and Colour jobs cannot be printed at the same time.
• No more than three jobs can use the printer simultaneously.
• Printing a single page takes the same time (1 sec) in all jobs.
• Each job can have different number of pages to print, therefore, can take different time to print.
• A Monochrome job with ID y (i.e. My) should NOT be served before a Monochrome job with ID x (i.e. Mx) where x < y. And the same for the Colour jobs.
• No time is wasted in job selection and dispatching.

Using monitor, design and implement an algorithm that ensures the operation of the multi-printer according to the above characteristics. Use threads to simulate multiple concurrent printing jobs. Your solution should be fair – stream of Monochrome printing jobs should not cause the Colour Printing jobs wait forever or vice versa.

MARKING CRITERIA:
Algorithms (75%)
Problem 1 (A2.a) – (Semaphore use, Deadlock, Starvation Free) 30% - MARK: 30/30
Problem 2 (A2.b) – (Monitor use, Correct Synchronisation, Starvation Free) 30% - MARK: 30/30

Report (10%)
Length, Format, Does it satisfy the report specification? - MARK: 10/10

Code Form (10%)
Readability, Consistency, Appropriate Commenting. - MARK: 10/10

Input/Output (5%)
Is the output presented in the same manner as the sample? - MARK: 5/5

EXECUTION:
To run file, navigate to the p2 folder in terminal and paste in the following command.

javac P1.java && java P1 P1-1in.txt


