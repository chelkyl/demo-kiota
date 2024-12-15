# ignore comments
/^<!-- .* -->$/ { next; };
/^<!-- *$/,/^--> *$/ { next; };
# on empty line, determine current section
/^$/ {
    if (! in_summary && ! in_body) {
        in_summary=1;
        next;
    } else if (in_summary) {
        in_body=1;
        in_summary=0;
        next;
    } else {
        in_summary=1;
        in_body=0;
        next;
    };
};
# handle current line
in_body {
    next;
};
in_summary {
    print $0;
    next;
};
