package org.watertemplate.interpreter.parser;

import org.junit.Test;
import org.watertemplate.interpreter.lexer.TokenFixture;
import org.watertemplate.interpreter.parser.exception.IncorrectLocationForToken;

import static org.junit.Assert.assertNotNull;
import static org.watertemplate.interpreter.lexer.TokenFixture.Accessor;

public class NonTerminalIdTest {
    @Test
    public void singlePropertyKey() {
        TokenStream tokenStream = new TokenStream(
            new TokenFixture.PropertyKey("x")
        );

        assertNotNull(NonTerminal.ID.buildParseTree(tokenStream));
    }

    @Test
    public void nestedProperties() {
        TokenStream tokenStream = new TokenStream(
            new TokenFixture.PropertyKey("x"),
            new Accessor(),
            new TokenFixture.PropertyKey("y")
        );

        assertNotNull(NonTerminal.ID.buildParseTree(tokenStream));
    }

    @Test (expected = IncorrectLocationForToken.class)
    public void doubleAccessor() {
        TokenStream tokenStream = new TokenStream(
            new TokenFixture.PropertyKey("x"),
            new Accessor(),
            new Accessor(),
            new TokenFixture.PropertyKey("y")
        );

        NonTerminal.START_SYMBOL.buildParseTree(tokenStream);
    }

    @Test (expected = IncorrectLocationForToken.class)
    public void extraAccessor() {
        TokenStream tokenStream = new TokenStream(
            new TokenFixture.PropertyKey("x"),
            new Accessor(),
            new TokenFixture.PropertyKey("y"),
            new Accessor()
        );

        NonTerminal.START_SYMBOL.buildParseTree(tokenStream);
    }
}