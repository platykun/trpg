function rollDice(diceNumber, faceNumber) {
	var result = 0;
	for (i = 0; i < diceNumber; i++) {
		result += Math.floor(Math.random() * faceNumber) + 1;
	}

	return result;
}