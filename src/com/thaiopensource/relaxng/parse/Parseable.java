package com.thaiopensource.relaxng.parse;

public interface Parseable {
  ParsedPattern parse(SchemaBuilder f) throws BuildException, IllegalSchemaException;
  void parseInclude(String uri, SchemaBuilder f, IncludedGrammar g)
          throws BuildException, IllegalSchemaException;
  ParsedPattern parseExternal(String uri, SchemaBuilder f, Scope s)
          throws BuildException, IllegalSchemaException;
}
