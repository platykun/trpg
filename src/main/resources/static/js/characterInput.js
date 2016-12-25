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
function createSkillSelect() {
	var skillList = [ '-', '言いくるめ', '医学', '運転（自動車）', '応急手当', 'オカルト', '回避', '化学',
			'鍵開け', '隠す', '隠れる', '機械修理', '聞き耳', 'クトゥルフ神話', '芸術', '経理', '考古学',
			'コンピューター', '忍び歩き', '写真術', '重機械操作', '乗馬', '信用', '心理学', '人類学', '水泳',
			'制作1', '制作2', '制作3', '精神分析', '生物学', '説得', '操縦1', '操縦2', '操縦3',
			'地質学', '跳躍', '追跡', '電気修理', '電子工学', '天文学', '投擲', '登攀', '図書館',
			'ナビゲート', '値切り', '博物学', '物理学', '変装', '法律', '他の言語1', '他の言語2', '母国語',
			'ﾏｰｼｬﾙｱｰﾂ', '目星', '薬学', '歴史1', '歴史2', 'サブマシンガン', 'ショットガン', 'マシンガン',
			'ライフル', 'キック', '組み付き', 'こぶし', '頭突き', '近接戦1', '近接戦2', '火器1', '火器2',
			'火器3', '火器4', '火器5', '火器6' ];
	var objects = document.getElementsByClassName("skillSelect");
	for (var i = 0, len = objects.length; i < len; i++) {
		for (var j = 0, sLen = skillList.length; j < sLen; j++) {
			var option = document.createElement('option');
			option.textContent = skillList[j];
			objects.item(i).appendChild(option);
		}
	}
}
function updateSkillSelect(s1, s2, s3, s4, s5, s6, s7, s8){
document.getElementById("skillSelect1").getElementsByTagName('option')[s1].selected = true;
document.getElementById("skillSelect2").getElementsByTagName('option')[s2].selected = true;
document.getElementById("skillSelect3").getElementsByTagName('option')[s3].selected = true;
document.getElementById("skillSelect4").getElementsByTagName('option')[s4].selected = true;
document.getElementById("skillSelect5").getElementsByTagName('option')[s5].selected = true;
document.getElementById("skillSelect6").getElementsByTagName('option')[s6].selected = true;
document.getElementById("skillSelect7").getElementsByTagName('option')[s7].selected = true;
document.getElementById("skillSelect8").getElementsByTagName('option')[s8].selected = true;
}
function updateSkillBackgroundsColor(){
    updateSkillBackgroundColor(document.getElementById("skillSelect1").value);
    updateSkillBackgroundColor(document.getElementById("skillSelect2").value);
    updateSkillBackgroundColor(document.getElementById("skillSelect3").value);
    updateSkillBackgroundColor(document.getElementById("skillSelect4").value);
    updateSkillBackgroundColor(document.getElementById("skillSelect5").value);
    updateSkillBackgroundColor(document.getElementById("skillSelect6").value);
    updateSkillBackgroundColor(document.getElementById("skillSelect7").value);
    updateSkillBackgroundColor(document.getElementById("skillSelect8").value);
}

function updateSkillBackgroundColor(value){
    var element;
    if(value == '言いくるめ'){
        element = document.getElementById('dictionaryTr');
    }else if(value == '医学'){
        element = document.getElementById('medicineTr');
    }
    element.style.backgroundColor='Yellow';
    element.childNodes.item(3).childNodes.item(0).className = "skillText expert";
}
function clearSkillBackgroundColor(){
    document.getElementById('dictionaryTr').style.backgroundColor='';
    document.getElementById('dictionaryTr').childNodes.item(3).childNodes.item(0).className = "skillText beginner";
    document.getElementById('medicineTr').style.backgroundColor='';
    document.getElementById('medicineTr').childNodes.item(3).childNodes.item(0).className = "skillText beginner";
}
function getExpertTotalValue(){
    var length = document.getElementsByClassName('skillText expert').length;
    var total = 0;
    for(var i = 0;i < length; i++){
        total += parseInt(document.getElementsByClassName('skillText expert').item(i).value);
    }
    return total;
}
function getBeginnerTotalValue(){
    var length = document.getElementsByClassName('skillText beginner').length;
    var total = 0;
    for(var i = 0;i < length; i++){
        total += parseInt(document.getElementsByClassName('skillText beginner').item(i).value);
    }
    return total;
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
	var select = $('#job').val();
	if (select == 1) {
		updateSkillSelect(1,2,3,4,5,6,7,0);
	}else if (select == 2){
		updateSkillSelect(8,9,10,11,12,13,14,0);
	}else if (select == 3){
		updateSkillSelect(15,16,17,18,19,20,21,0);
	}
	clearSkillBackgroundColor();
	updateSkillBackgroundsColor();
});
$('.skillSelect').change(function(){
    clearSkillBackgroundColor();
    updateSkillBackgroundsColor();
});
$('#expertProgress').progress({
    label: 'ratio',
    text: {
      ratio: '{value} ¥/ {total}'
    }
});