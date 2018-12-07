$(function(){
    function NewDate(str) {
        str = str.split('-');
        var date = new Date();
        date.setUTCFullYear(str[0], str[1] - 1, str[2]);
        date.setUTCHours(0, 0, 0, 0);
        return date;
    }
    function showsectime() {
        var birthDay = NewDate("2018-09-06"); //修改此处建站时间
        var today = new Date();
        var timeold = today.getTime() - birthDay.getTime();
        var msPerDay = 24 * 60 * 60 * 1000;
        var e_daysold = timeold / msPerDay;
        var daysold = Math.floor(e_daysold);
        var e_hrsold = (daysold - e_daysold) * -24;
        var hrsold = Math.floor(e_hrsold);
        var e_minsold = (hrsold - e_hrsold) * -60;
        var minsold = Math.floor((hrsold - e_hrsold) * -60);
        var seconds = Math.floor((minsold - e_minsold) * -60).toString();
        if (daysold >= 10) {
            document.getElementById("daysold").innerHTML = daysold;
        } else {
            document.getElementById("daysold").innerHTML = '0' + daysold;
        }
        if (hrsold >= 10) {
            document.getElementById("hrsold").innerHTML = hrsold;
        } else {
            document.getElementById("hrsold").innerHTML = '0' + hrsold;
        }
        if (minsold >= 10) {
            document.getElementById("minsold").innerHTML = minsold;
        } else {
            document.getElementById("minsold").innerHTML = '0' + minsold;
        }
        if (seconds >= 10) {
            document.getElementById("seconds").innerHTML = seconds;
        } else {
            document.getElementById("seconds").innerHTML = '0' + seconds;
        }
        setTimeout(showsectime, 1000);
    }
    showsectime();
})