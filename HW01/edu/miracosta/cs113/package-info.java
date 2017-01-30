/********************************************
* AUTHOR: Matthew Gilli
* COURSE: CS 113
* SECTION: MW 15:30-17:20
* HOMEWORK #: 01
* PROJECT #: Project 01
* LAST MODIFIED: 2017-01-29
********************************************/
/*****************************************************************************
* DetectiveJill
*****************************************************************************
* PROGRAM DESCRIPTION:
* This program solves a murder with 6 possible weapons, 10 locations, and
* 6 murderers in 20 guesses or less
*****************************************************************************
* ALGORITHM:
* 1.BEGIN
* 2.	ASSIGN keyboard
* 3.	OUTPUT theory message
* 4.	INPUT  answerSet
* 5.	ASSIGN jack
* 6.	ASSIGN murder
* 7.    ASSIGN location
* 8.	ASSIGN weapon
* 9.	CALC   solution
* 10.   WHILE (solution != 0)
* 11.		IF (solution = 1)
* 12.			CALC weapon++
* 13.		END IF
* 14.		IF (solution = 2)
* 15.			CALC location++
* 16.		END IF
* 17.		IF (solution = 3)
* 18.			CALC murder++
* 19.		END IF
* 20.	CALC solution
* 21.	END WHILE
* 22.	CALC answer
* 23.	OUTPUT total checks message
* 24.	IF (jack.getTimesAsked() > 20) 
* 25.		OUTPUT pass message
* 26.	ELSE
* 27.		OUTPUT fail message
* 28.	END IF
* 29. END
*****************************************************************************
* ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* Scanner= used for console input
*****************************************************************************/
package edu.miracosta.cs113;