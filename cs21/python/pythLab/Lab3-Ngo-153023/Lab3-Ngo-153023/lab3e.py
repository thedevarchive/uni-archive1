#Alyssa Mae King Ngo
#153023
#September 8, 2016

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

palindromes = int(input()) 

while palindromes > 0:
	nos = int(input())
	nmstr = raw_input()
	spl = nmstr.split() # for split
	last = len(spl) - 1
	first = 0
	
	while last - first >= 1:
	
		if spl[last] != spl[first]:
			print("No")
			break
			
		if last - first == 2 or last - first == 1:
			print("Yes")
			
		last = last - 1
		first = first + 1
		
	palindromes = palindromes - 1
	