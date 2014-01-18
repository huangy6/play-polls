
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[org.dupontmanual.forms.Binding,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: org.dupontmanual.forms.Binding):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.40*/("""

"""),_display_(Seq[Any](/*3.2*/main("Login")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
  """),_display_(Seq[Any](/*4.4*/form/*4.8*/.render())),format.raw/*4.17*/("""
""")))})),format.raw/*5.2*/("""
"""))}
    }
    
    def render(form:org.dupontmanual.forms.Binding): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((org.dupontmanual.forms.Binding) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 06 12:45:07 EST 2014
                    SOURCE: /media/SpecTops/blogs/play-polls/app/views/login.scala.html
                    HASH: f267a49b50063a9d3bd661dfbb3a94125fbcde21
                    MATRIX: 580->1|712->39|749->42|770->55|809->57|847->61|858->65|888->74|920->76
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5
                    -- GENERATED --
                */
            