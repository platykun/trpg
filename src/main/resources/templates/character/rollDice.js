function rollDice(diceNumber, faceNumber) {
	var result;
	for (i = 0; i != faceNumber; i++){		
		result += Math.floor(Math.random() * faceNumber) + 1;
	}
		return result;
}