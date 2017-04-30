# spellChecker
simple spell checker with GUI
This spell checker accept a dictionary file and a text file as input, write corrected text to a new file as output

Specifications:
1. dictionary and text file have a filter to .txt or .csv format (which is optional). The path of file is to be chosen through GUI.
   Any format or delimiter will be accepted and handled, which contains but not limits to space, comma, line break, slash, etc.
   If the Operator fail to choose a file as input, it is assumed that Operator does not want to continue with the program, and the program
   will terminate.
   In case of failure to read the file, message "wrong file path" will be displayed as a notice.

2. The check of spelling will happen parallely with one word per thread, and for each wrongly spelled word detected, the Operator is
   expected to propose a correction in the prompted window. The second textfield is for operator to enter, labeled "Correction".
   The entered correction will not be spell-checked for a second time. 
   The input can be confirmed either by clicking button "Submit" or press the enter key.
   If the Operator close the window without confirming input, it is assumed that no correction is needed for the word and the original will
   be kept. The window will be closed upon confirming input.
   
3. After proposing all corrections, Operator will be asked to choose or enter the path of location of file which will store the new text
   If the operator fails to choose the path, it is assumed that no storing is required and the program will terminate
   Once the path is set, a new text with all correction pair replaced will be stpred at the path. The correction is word-based, so there
   is no worry that pattern inside a word will be replaced.
   
4. Current test case contains a set of test file at root directory. This test file contains the test for read file with different 
   delimiters and the test of not rewrite pattern inside a word. Further test case may be added at April 30.
   
Thanks for reading
