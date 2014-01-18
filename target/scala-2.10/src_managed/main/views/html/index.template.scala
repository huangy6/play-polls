
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
},play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String)(implicit req: Request[_]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.api.mvc._


Seq[Any](format.raw/*1.45*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(message)/*5.15*/ {_display_(Seq[Any](format.raw/*5.17*/("""

	<h3>Survey Says...This is your Poll application.</h3>
	<br/>
    """),_display_(Seq[Any](/*9.6*/message)),format.raw/*9.13*/("""
    <br/>
    
    """),_display_(Seq[Any](/*12.6*/req/*12.9*/.session.get("user")/*12.29*/ match/*12.35*/ {/*13.7*/case Some(_) =>/*13.22*/ {_display_(Seq[Any](format.raw/*13.24*/("""
        <form method="post" action="/logout">
          <button type="submit" class="btn">Logout</button>
        </form>
      """)))}/*18.7*/case None =>/*18.19*/ {_display_(Seq[Any](format.raw/*18.21*/(""" 
        <form method="get" action="/login">
          <button type="submit" class="btn">Login</button>
        </form>
      """)))}})),format.raw/*23.6*/("""
	
""")))})),format.raw/*25.2*/(""" 

"""))}
    }
    
    def render(message:String,req:Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}): play.api.templates.HtmlFormat.Appendable = apply(message)(req)
    
    def f:((String) => (Request[_$1] forSome { 
   type _$1 >: _root_.scala.Nothing <: _root_.scala.Any
}) => play.api.templates.HtmlFormat.Appendable) = (message) => (req) => apply(message)(req)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jan 18 16:45:05 EST 2014
                    SOURCE: /media/SpecTops/blogs/play-polls/app/views/index.scala.html
                    HASH: 9e939f0fa244544897f4ceb4a9f536d75a851a4c
                    MATRIX: 638->1|797->44|825->69|861->71|882->84|921->86|1024->155|1052->162|1108->183|1119->186|1148->206|1163->212|1173->222|1197->237|1237->239|1385->377|1406->389|1446->391|1606->525|1641->529
                    LINES: 21->1|25->1|27->4|28->5|28->5|28->5|32->9|32->9|35->12|35->12|35->12|35->12|35->13|35->13|35->13|39->18|39->18|39->18|43->23|45->25
                    -- GENERATED --
                */
            