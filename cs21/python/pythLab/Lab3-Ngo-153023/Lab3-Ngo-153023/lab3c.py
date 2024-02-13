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

sz = int(input()) # 1st ln
nums = input() # 2nd ln
nmlis = nums.split()
quers = int(input()) #3rd ln
qnums = input() #4th ln
q = qnums.split()
c = 0

while quers > 0:
	current = int(q[c])
	if current > 0 and current <= sz:
		print(nmlis[current - 1])
	else:
		print('NO')
	quers = quers - 1
	c = c + 1