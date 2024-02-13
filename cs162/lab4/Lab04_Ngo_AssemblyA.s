	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 10, 14
	.globl	__Z5dummyiii            ## -- Begin function _Z5dummyiii
	.p2align	4, 0x90
__Z5dummyiii:                           ## @_Z5dummyiii
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	%edi, -4(%rbp)
	movl	%esi, -8(%rbp)
	movl	%edx, -12(%rbp)
	movl	-4(%rbp), %edx
	addl	-8(%rbp), %edx
	movl	%edx, -16(%rbp)
	movl	-4(%rbp), %edx
	addl	-12(%rbp), %edx
	movl	%edx, -20(%rbp)
	movl	-16(%rbp), %edx
	addl	-20(%rbp), %edx
	movl	%edx, %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function

.subsections_via_symbols
