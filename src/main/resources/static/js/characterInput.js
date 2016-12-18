function setRelatedParam() {
	setIdea();
	setSanSanValue();
	setMp();
	setKnowledge();
	setDurability();
	setDamageBonus();
}
function setIdea() {
	$('#idea').text($('#int').val() * 5);
}
function setSanSanValue() {
	$('#fortune').text($('#pow').val() * 5);
	var sanValue = $('#pow').val() * 5;
	var maxSan = 99 - $('#cthulhuMythos').val();
	if (sanValue > maxSan) {
		sanValue = maxSan;
	}
	$('#san').text(sanValue);
	$('#sanity').text(sanValue);
}
function setMp() {
	$('#mp').text($('#pow').val());
}
function setKnowledge() {
	$('#knowledge').text($('#edu').val() * 5);
}
function setDurability() {
	var durabilityValue = Math.ceil((parseInt($('#con').val()) + parseInt($(
			'#siz').val())) / 2);
	$('#durability').text(durabilityValue);
}
function setDamageBonus() {
	var total = parseInt($('#str').val()) + parseInt($('#siz').val());
	var text = '2 ≦ STR + SIZ ≦ 72';
	if (total < 13) {
		text = '-1D6';
	} else if (total < 17) {
		text = '-1D4';
	} else if (total < 25) {
		text = '±0';
	} else if (total < 33) {
		text = '+1D4';
	} else if (total < 41) {
		text = '+1D6';
	} else if (total < 57) {
		text = '+2D6';
	} else if (total < 73) {
		text = '+3D6'
	}
	$('#damageBonus').text(text);
}
function setAbilityRandom() {
	$('#str').val(rollDice(3, 6));
	$('#con').val(rollDice(3, 6));
	$('#siz').val(rollDice(2, 6) + 6);
	$('#dex').val(rollDice(3, 6));
	$('#app').val(rollDice(3, 6));
	$('#int').val(rollDice(2, 6) + 6);
	$('#pow').val(rollDice(3, 6));
	$('#edu').val(rollDice(3, 6) + 3);
}

$('#int').keyup(function() {
	setIdea();
});
$('#pow').keyup(function() {
	setSanSanValue();
	setMp();
});
$('#edu').keyup(function() {
	setKnowledge();
});
$('#con, #siz').keyup(function() {
	setDurability();
});
$('#str, #siz').keyup(function() {
	setDamageBonus();
});
$('#abilityRamdom').click(function() {
	setAbilityRandom();
	setRelatedParam();
});
$('#job').change(function() {
	var select = $('#str').val();
	if (select == 1) {
		// 医師
	}
});
