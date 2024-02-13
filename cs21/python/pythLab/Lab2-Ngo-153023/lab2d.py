#Alyssa Mae Ngo
#153023
#August 30, 2016

"""
I hereby attest to the truth of the following facts:

I have not discussed the Python language code in my program
with anyone other than my instructor or the teaching assistants assigned to this course.

I have not used Python language code obtained from another
student, or any other unauthorized source, either modified or unmodified.

If any Python language code or documentation used in my
program was obtained from another source, such as a text book or course notes, that has
been clearly noted with a proper citation in the comments of my program.
"""

from __future__ import print_function

#This source taught me to import this function before using end in a print function
#http://stackoverflow.com/questions/2456148/python-print-end

no = 0
	
while no != -1:
	cou1 = 1
	cou2 = 1
	no = int(input())
	while cou1 <= no:
		while cou1 >= cou2:
			if cou2 == cou1:
				print(cou2)
			else:
				print(cou2, end = ' ')
				#Thanks to this source for teaching me how to print in python w/o newline
				#http://stackoverflow.com/questions/493386/how-to-print-in-python-without-newline-or-space
			cou2 = cou2 + 1
		cou2 = 1
		cou1 = cou1 + 1
	print('')