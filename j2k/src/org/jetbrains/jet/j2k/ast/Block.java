/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.j2k.ast;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.j2k.util.AstUtil;

import java.util.LinkedList;
import java.util.List;

public class Block extends Statement {
    @NotNull
    public final static Block EMPTY_BLOCK = new Block();

    private List<Statement> myStatements;
    private boolean myNotEmpty = false;

    private Block() {
        myStatements = new LinkedList<Statement>();
    }

    public Block(List<Statement> statements) {
        myStatements = new LinkedList<Statement>();
        myStatements = statements;
    }

    public Block(List<Statement> statements, boolean notEmpty) {
        myStatements = new LinkedList<Statement>();
        myStatements = statements;
        myNotEmpty = notEmpty;
    }

    public boolean isEmpty() {
        return !myNotEmpty && myStatements.size() == 0;
    }

    public List<Statement> getStatements() {
        return myStatements;
    }

    @NotNull
    @Override
    public String toKotlin() {
        if (!isEmpty()) {
            return "{" + N +
                   AstUtil.joinNodes(myStatements, N) + N +
                   "}";
        }
        return EMPTY;
    }
}
