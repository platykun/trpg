function rollDice(diceNumber, faceNumber) {
	console.log(diceNumber);
	var result = 0;
	for (i = 0; i < diceNumber; i++) {
		result += Math.floor(Math.random() * faceNumber) + 1;
	}

	var array = [ {
		diceNumber : diceNumber,
		faceNumber : faceNumber,
		result : result,
	} ];
	console.table(array);

	return result;
}