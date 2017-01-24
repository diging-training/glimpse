<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="jumbotron col-md-12">

<sec:authorize access="isAnonymous()">
<h1>Congratulation!</h1>
<p>
You did it. This basic webapp is all set up now. Try to login as "admin" with password "admin".
</p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<h1>Whoohoo!</h1>
<p>You are logged in.</p>
</sec:authorize>
</div>

<p>
The quick, <a href="">brown fox jumps</a> over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt fox. Bright vixens jump; dozy fowl quack. Quick wafting zephyrs vex bold Jim. Quick zephyrs blow, vexing daft Jim. Sex-charged fop blew my junk TV quiz. How quickly daft jumping zebras vex. Two driven jocks help fax my big quiz. Quick, Baz, get my woven flax jodhpurs! "Now fax quiz Jack!" my brave ghost pled. Five quacking zephyrs jolt my wax bed. Flummoxed by job, kvetching W. zaps Iraq. 
</p>