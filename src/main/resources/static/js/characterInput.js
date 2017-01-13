var skillList = [
	{id:'0', name:'-', id:''},
	{id:'1', name:'言いくるめ', id:'dictionary'},
	{id:'2', name:'医学', id:'medicine'},
	{id:'3', name:'運転（自動車）', id:'driveCarriage'},
	{id:'4', name:'応急手当', id:'firstAid'},
	{id:'5', name:'オカルト', id:'occult'},
	{id:'6', name:'回避', id:'dodge'},
	{id:'7', name:'化学', id:'chemistry'},
	{id:'8', name:'鍵開け', id:'locksmith'},
	{id:'9', name:'隠す', id:'conceal'},
	{id:'10', name:'隠れる', id:'hide'},
	{id:'11', name:'機械修理', id:'mechanicalRepair'},
	{id:'12', name:'聞き耳', id:'listen'},
	{id:'13', name:'クトゥルフ神話', id:'cthulhuMythos'},
	{id:'14', name:'芸術', id:'art'},
	{id:'15', name:'経理', id:'accounting'},
	{id:'16', name:'考古学', id:'archaeology'},
	{id:'17', name:'コンピューター', id:'computer'},
	{id:'18', name:'忍び歩き', id:'sneak'},
	{id:'19', name:'写真術', id:'photography'},
	{id:'20', name:'重機械操作', id:'operateHvyMachine'},
	{id:'21', name:'乗馬', id:'ride'},
	{id:'22', name:'信用', id:'creditRating'},
	{id:'23', name:'心理学', id:'psychology'},
	{id:'24', name:'人類学', id:'anthropology'},
	{id:'25', name:'水泳', id:'swim'},
	{id:'26', name:'制作1', id:'production1'},
	{id:'27', name:'制作2', id:'production2'},
	{id:'28', name:'制作3', id:'production3'},
	{id:'29', name:'精神分析', id:'psychoanalysis'},
	{id:'30', name:'生物学', id:'biology'},
	{id:'31', name:'説得', id:'persuade'},
	{id:'32', name:'操縦1', id:'pilot1'},
	{id:'33', name:'操縦2', id:'pilot2'},
	{id:'34', name:'操縦3', id:'pilot3'},
	{id:'35', name:'地質学', id:'geology'},
	{id:'36', name:'跳躍', id:'jump'},
	{id:'37', name:'追跡', id:'pursuit'},
	{id:'38', name:'電気修理', id:'electricalRepair'},
	{id:'39', name:'電子工学', id:'electronics'},
	{id:'40', name:'天文学', id:'astronomy'},
	{id:'41', name:'投擲', id:'throwSomething'},
	{id:'42', name:'登攀', id:'climb'},
	{id:'43', name:'図書館', id:'library'},
	{id:'44', name:'ナビゲート', id:'navigate'},
	{id:'45', name:'値切り', id:'priceCut'},
	{id:'46', name:'博物学', id:'naturalHistory'},
	{id:'47', name:'物理学', id:'physics'},
	{id:'48', name:'変装', id:'disguise'},
	{id:'49', name:'法律', id:'law'},
	{id:'50', name:'他の言語1', id:'otherLanguage1'},
	{id:'51', name:'他の言語2', id:'otherLanguage2'},
	{id:'52', name:'母国語', id:'ownLanguage'},
	{id:'53', name:'ﾏｰｼｬﾙｱｰﾂ', id:'martial'},
	{id:'54', name:'目星', id:'spotHidden'},
	{id:'55', name:'薬学', id:'pharmacy'},
	{id:'56', name:'歴史1', id:'history1'},
	{id:'57', name:'歴史2', id:'history2'},
	{id:'58', name:'サブマシンガン', id:'subMachineGun'},
	{id:'59', name:'ショットガン', id:'shotgun'},
	{id:'60', name:'マシンガン', id:'machineGun'},
	{id:'61', name:'ライフル', id:'rifle'},
	{id:'62', name:'キック', id:'kick'},
	{id:'63', name:'組み付き', id:'assembly'},
	{id:'64', name:'こぶし', id:'first'},
	{id:'65', name:'頭突き', id:'headButt'},
	{id:'66', name:'近接戦1', id:'handWeapon1'},
	{id:'67', name:'近接戦2', id:'handWeapon2'},
	{id:'68', name:'火器1', id:'firearm1'},
	{id:'69', name:'火器2', id:'firearm2'},
	{id:'70', name:'火器3', id:'firearm3'},
	{id:'71', name:'火器4', id:'firearm4'},
	{id:'72', name:'火器5', id:'firearm5'},
	{id:'73', name:'火器6', id:'firearm6'}
];
var jobSkillList = [
    {id:0, name:'-',skills:9, s1:0, s2:0, s3:0, s4:0, s5:0, s6:0, s7:0, s8:0,s9:0, comment:''},
    {id:1, name:'医師',skills:9, s1:2, s2:4, s3:22, s4:23, s5:29, s6:30, s7:50, s8:55, s9:0, comment:'他の言語：ラテン語 個人的、もしくはその時代の特色的な技能１つ'},
    {id:2, name:'エンジニア',skills:8, s1:7, s2:11, s3:20, s4:38, s5:35, s6:43, s7:47, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:3, name:'エンターテイナー',skills:8, s1:1, s2:6, s3:12, s4:14, s5:22, s6:23, s7:48, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:4, name:'教授',skills:8, s1:22, s2:23, s3:31, s4:43, s5:45, s6:50, s7:0, s8:0, s9:0, comment:'下記の技能より2つ(専攻など)'},
    {id:5, name:'狂信者',skills:8, s1:9, s2:10, s3:23, s4:31, s5:43, s6:0, s7:0, s8:0, s9:0, comment:'次の技能より2つ 更に個人的、もしくはその時代の特色的な技能１つ'},
    {id:6, name:'軍師官',skills:8, s1:15, s2:22, s3:23, s4:31, s5:44, s6:45, s7:49, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:7, name:'警官',skills:8, s1:1, s2:4, s3:6, s4:63, s5:23, s6:49, s7:0, s8:0, s9:0, comment:'下記の技能より2つ'},
    {id:8, name:'刑事',skills:8, s1:1, s2:12, s3:23, s4:31, s5:45, s6:49, s7:54, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:9, name:'芸術家',skills:8, s1:1, s2:14, s3:19, s4:23, s5:26, s6:54, s7:56, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:10, name:'古物研究科',skills:8, s1:14, s2:26, s3:43, s4:45, s5:50, s6:54, s7:56, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:11, name:'作家',skills:8, s1:5, s2:23, s3:31, s4:43, s5:50, s6:52, s7:56, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:12, name:'ジャーナリスト',skills:8, s1:1, s2:19, s3:23, s4:31, s5:43, s6:52, s7:56, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:13, name:'私立探偵',skills:8, s1:1, s2:8, s3:19, s4:23, s5:43, s6:45, s7:49, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:14, name:'スポークスマン',skills:8, s1:1, s2:6, s3:22, s4:23, s5:31, s6:48, s7:0, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:15, name:'スポーツ選手',skills:8, s1:6, s2:21, s3:25, s4:36, s5:41, s6:42, s7:53, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:16, name:'聖職者',skills:8, s1:12, s2:15, s3:23, s4:31, s5:43, s6:50, s7:56, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:17, name:'超心理学社',skills:8, s1:5, s2:24, s3:19, s4:23, s5:43, s6:50, s7:56, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能１つ'},
    {id:18, name:'ディレッタント',skills:8, s1:14, s2:21, s3:59, s4:22, s5:26, s6:50, s7:0, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能2つ'},
    {id:19, name:'伝道者',skills:7, s1:2, s2:4, s3:11, s4:14, s5:31, s6:46, s7:0, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:20, name:'トライブ・メンバー',skills:8, s1:5, s2:12, s3:25, s4:41, s5:45, s6:46, s7:54, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:21, name:'農林業作業者',skills:8, s1:4, s2:11, s3:20, s4:26, s5:37, s6:38, s7:46, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:22, name:'パイロット',skills:8, s1:11, s2:20, s3:38, s4:32, s5:40, s6:44, s7:47, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:23, name:'ハッカー/コンサルタント',skills:8, s1:1, s2:17, s3:38, s4:39, s5:43, s6:47, s7:50, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:24, name:'犯罪者',skills:8, s1:1, s2:8, s3:68, s4:18, s5:45, s6:48, s7:54, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:25, name:'兵士',skills:8, s1:4, s2:6, s3:9, s4:11, s5:12, s6:18, s7:61, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:26, name:'弁護士',skills:8, s1:1, s2:22, s3:23, s4:31, s5:43, s6:45, s7:49, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:27, name:'放浪者',skills:8, s1:1, s2:10, s3:12, s4:18, s5:23, s6:45, s7:46, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'},
    {id:28, name:'ミュージシャン',skills:8, s1:1, s2:12, s3:14, s4:26, s5:31, s6:23, s7:45, s8:0, s9:0, comment:'個人的、もしくはその時代の特色的な技能1つ'}
];

function setRelatedParam() {
	setIdea();
	setSanSanValue();
	setMp();
	setKnowledge();
	setDurability();
	setDamageBonus();
	setExpertMaxPoint();
	setBeginnerMaxPoint();
	updateSkillProgress();
	setDodge();
	setOwnLanguage();
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
function setExpertMaxPoint(){
	$('#expertMaxPoint').text($('#edu').val() * 20);
}
function setBeginnerMaxPoint(){
	$('#beginnerMaxPoint').text($('#int').val() * 10);
}
function setDodge(){
	$('#dodge').val($('#int').val() * 2);
}
function setOwnLanguage(){
	$('#ownLanguage').val($('#edu').val() * 5);
	
}
function createSkillSelect() {
	var objects = document.getElementsByClassName("skillSelect");
	for (var i = 0, len = objects.length; i < len; i++) {
		for (var j = 0, sLen = skillList.length; j < sLen; j++) {
			var option = document.createElement('option');
			option.textContent = skillList[j].name;
			objects.item(i).appendChild(option);
		}
	}
}
function createJobSelect() {
	var jobObj = document.getElementById("job");
	for(var i = 0, len = jobSkillList.length; i < len; i++){
		var option = document.createElement('option');
		option.textContent = jobSkillList[i].name;
		option.value = i;
		jobObj.appendChild(option);
	}
}
function updateSkillSelect(s1, s2, s3, s4, s5, s6, s7, s8, s9){
	$('#skillSelect1').children('option')[s1].selected = true;
	$('#skillSelect2').children('option')[s2].selected = true;
	$('#skillSelect3').children('option')[s3].selected = true;
	$('#skillSelect4').children('option')[s4].selected = true;
	$('#skillSelect5').children('option')[s5].selected = true;
	$('#skillSelect6').children('option')[s6].selected = true;
	$('#skillSelect7').children('option')[s7].selected = true;
	$('#skillSelect8').children('option')[s8].selected = true;
	$('#skillSelect9').children('option')[s9].selected = true;
}
function updateSkillBackgroundsColor(){
    updateSkillBackgroundColor($('#skillSelect1').val());
    updateSkillBackgroundColor($('#skillSelect2').val());
    updateSkillBackgroundColor($('#skillSelect3').val());
    updateSkillBackgroundColor($('#skillSelect4').val());
    updateSkillBackgroundColor($('#skillSelect5').val());
    updateSkillBackgroundColor($('#skillSelect6').val());
    updateSkillBackgroundColor($('#skillSelect7').val());
    updateSkillBackgroundColor($('#skillSelect8').val());
    updateSkillBackgroundColor($('#skillSelect9').val());
}

function updateSkillBackgroundColor(value){
	if(value == '-')return;
    var element;
    for(var i = 0,len = skillList.length;i < len;i++){
    	if(value == skillList[i].name){
    		element = document.getElementById(skillList[i].id);
    		element.parentNode.parentNode.childNodes[1].classList.add('bg-warning');
    		element.classList.remove('beginner');
    		element.classList.add('expert');
    	}
    }
}
function clearSkillBackgroundColor(){
	for(var i = 0,len = skillList.length;i < len;i++){
		if(skillList[i].id !=''){
			document.getElementById(skillList[i].id).parentNode.parentNode.childNodes[1].classList.remove('bg-warning');		
			document.getElementById(skillList[i].id).classList.remove('expert');
			document.getElementById(skillList[i].id).classList.add('beginner');
		}
    }
}
function getExpertTotalValue(){
    var length = $('.skillText.expert').length;
    var total = 0;
    for(var i = 0;i < length; i++){
    	var element = document.getElementsByClassName('skillText expert').item(i);
    	var value = element.value - element.defaultValue;
    	if(value < 0){
    		continue;
    	}
        total += parseInt(value);
    }
    return total;
}
function getBeginnerTotalValue(){
    var length = $('.skillText.beginner').length;
    var total = 0;
    for(var i = 0;i < length; i++){
    	var element = document.getElementsByClassName('skillText beginner').item(i);
    	var value = element.value - element.defaultValue;
    	if(value < 0){
    		continue;
    	}
        total += parseInt(value);
    }
    return total;
}
function updateSkillPoint(){
	$('#expertSetPoint').text(getExpertTotalValue());
	$('#beginnerSetPoint').text(getBeginnerTotalValue());
}
function updateSkillProgress(){
	var eMax = parseInt(document.getElementById("expertMaxPoint").textContent);
	var eSet = parseInt(document.getElementById("expertSetPoint").textContent);
	var eProgress = parseInt((100 * eSet) / eMax);
//	if(eProgress == 100){
//		document.getElementById("expertProgressRoot").className = "ui progress success"
//	}else if(eProgress > 100){
//		document.getElementById("expertProgressRoot").className = "ui progress error"
//	}else{
//		document.getElementById("expertProgressRoot").className = "ui progress warning"		
//	}
	document.getElementById("expert-progress-bar").style.width = eProgress + "%";
	var bMax = parseInt(document.getElementById("beginnerMaxPoint").textContent);
	var bSet = parseInt(document.getElementById("beginnerSetPoint").textContent);
	var bProgress = parseInt((100 * bSet) / bMax);
//	if(bProgress == 100){
//		document.getElementById("beginnerProgressRoot").className = "ui progress success"
//	}else if(bProgress > 100){
//		document.getElementById("beginnerProgressRoot").className = "ui progress error"
//	}else{
//		document.getElementById("beginnerProgressRoot").className = "ui progress warning"		
//	}
	document.getElementById("beginner-progress-bar").style.width = bProgress + "%";
}


$('#int').keyup(function() {
	setIdea();
	setBeginnerMaxPoint();
	updateSkillProgress();
});
$('#pow').keyup(function() {
	setSanSanValue();
	setMp();
});
$('#edu').keyup(function() {
	setKnowledge();
	setExpertMaxPoint();
	updateSkillProgress();
	setOwnLanguage();
	updateSkillProgress();
});
$('#con, #siz').keyup(function() {
	setDurability();
});
$('#str, #siz').keyup(function() {
	setDamageBonus();
});
$('#dex').keyup(function() {
	setDodge();
});
$('#abilityRamdom').click(function() {
	setAbilityRandom();
	setRelatedParam();
});
$('#job').change(function() {
	var select = $('#job').val();
	if(select == ""){
		updateSkillSelect(0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	console.log(select);
	var js = jobSkillList[select];
	updateSkillSelect(js.s1, js.s2, js.s3, js.s4, js.s5, js.s6, js.s7, js.s8, js.s9);

	clearSkillBackgroundColor();
	updateSkillBackgroundsColor();
});
$('.skillSelect').change(function(){
    clearSkillBackgroundColor();
    updateSkillBackgroundsColor();
});
$('.skillText').change(function(){
	updateSkillPoint();
	updateSkillProgress();
});
