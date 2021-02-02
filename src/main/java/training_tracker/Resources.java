package training_tracker;

public final class Resources {
    private Resources() {
    }

    public static final String STAHTML = "<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\"/><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/><meta name=\"viewport\" content=\"width=device-width\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.min.css\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap-icons.css\"/></head><body><div class=\"container\"><h1>{type}</h1><a href=\"main.html\">Details</a> | <a href=\"lessons.html\">Lessons</a> | <a href=\"daily.html\">Daily</a><table class=\"table\"><thead><tr><th scope=\"col\">";

    public static final String LESTHHTML = "Status</th><th scope=\"col\">Id</th><th scope=\"col\">Name";
    public static final String DAITHHTML = "Status</th><th scope=\"col\">Day";
    public static final String DETTHHTML = "Type</th><th scope=\"col\">All</th><th scope=\"col\">Success</th><th scope=\"col\">Fail</th><th scope=\"col\">Percent";

    public static final String THFINALHTML = "</th></tr></thead><tbody>";

    public static final String LESTRHTML = "<tr><td><i class=\"{cssclass}\"></i></td><td><code>{pkgname}</code></td><td>{desc}</td></tr>";
    public static final String DAITRHTML = "<tr><td><i class=\"{cssclass}\"></i></td><td>{pkgname}</td></tr>";
    public static final String DETTRHTML = "<tr><td>{type}</td><td>{all}</td><td>{succes}</td><td>{fail}</td><td>{percent} %</td></tr>";

    public static final String SOUHTML = "<tr><td colspan=\"4\">Source code: <a href=\"https://github.com/kovacsgabor55/training-solutions/tree/master/src/main/java/training_tracker\">https://github.com/kovacsgabor55/training-solutions/tree/master/src/main/java/training_tracker</a></td></tr>";

    public static final String EOFHTML = "</tbody></table></div></body></html>\n";

    public static final String CSSOK = "bi-check-square text-success";
    public static final String CSSFAIL = "bi-x-square text-danger";
}