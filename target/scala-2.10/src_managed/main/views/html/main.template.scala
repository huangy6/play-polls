
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>
<html>
  <head>
    <title>"""),_display_(Seq[Any](/*6.13*/title)),format.raw/*6.18*/("""</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.55*/routes/*10.61*/.Assets.at("images/favicon.png"))),format.raw/*10.93*/("""">
    <script src=""""),_display_(Seq[Any](/*11.19*/routes/*11.25*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.70*/("""" type="text/javascript"></script>
  </head>
  <body>    
    <div class="container">
      <h1>"""),_display_(Seq[Any](/*15.12*/title)),format.raw/*15.17*/("""</h1>
    
      """),_display_(Seq[Any](/*17.8*/content)),format.raw/*17.15*/("""
    </div>
  </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 06 12:45:07 EST 2014
                    SOURCE: /media/SpecTops/blogs/play-polls/app/views/main.scala.html
                    HASH: 31d0d9434e3f575c4ec01d15e0264e7c8e2ce244
                    MATRIX: 560->1|684->31|765->77|791->82|1184->439|1199->445|1253->477|1310->498|1325->504|1392->549|1525->646|1552->651|1605->669|1634->676
                    LINES: 19->1|22->1|27->6|27->6|31->10|31->10|31->10|32->11|32->11|32->11|36->15|36->15|38->17|38->17
                    -- GENERATED --
                */
            