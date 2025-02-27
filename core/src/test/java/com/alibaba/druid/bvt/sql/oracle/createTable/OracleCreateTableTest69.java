/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.sql.oracle.createTable;

import com.alibaba.druid.sql.OracleTest;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

public class OracleCreateTableTest69 extends OracleTest {
    public void test_types() throws Exception {
        String sql = //
                "  CREATE TABLE HASH_TABLE\n" +
                        "(\n" +
                        "COL NUMBER(8),\n" +
                        "INF VARCHAR2(100)\n" +
                        ")\n" +
                        "PARTITION BY HASH (COL)\n" +
                        "(\n" +
                        "PARTITION PART01 TABLESPACE HASH_TS01,\n" +
                        "PARTITION PART02 TABLESPACE HASH_TS02,\n" +
                        "PARTITION PART03 TABLESPACE HASH_TS03\n" +
                        ") ";

        List<SQLStatement> statementList = SQLUtils.parseStatements(sql, JdbcConstants.ORACLE);
        SQLStatement stmt = statementList.get(0);
        print(statementList);

        assertEquals(1, statementList.size());
//
        assertEquals("CREATE TABLE HASH_TABLE (\n" +
                        "\tCOL NUMBER(8),\n" +
                        "\tINF VARCHAR2(100)\n" +
                        ")\n" +
                        "PARTITION BY HASH (COL) (\n" +
                        "\tPARTITION PART01\n" +
                        "\t\tTABLESPACE HASH_TS01,\n" +
                        "\tPARTITION PART02\n" +
                        "\t\tTABLESPACE HASH_TS02,\n" +
                        "\tPARTITION PART03\n" +
                        "\t\tTABLESPACE HASH_TS03\n" +
                        ")",//
                SQLUtils.toSQLString(stmt, JdbcConstants.ORACLE));
//
//        SchemaStatVisitor visitor = SQLUtils.createSchemaStatVisitor(JdbcConstants.ORACLE);
//        stmt.accept(visitor);
//
//        System.out.println("Tables : " + visitor.getTables());
//        System.out.println("fields : " + visitor.getColumns());
//        System.out.println("coditions : " + visitor.getConditions());
//        System.out.println("relationships : " + visitor.getRelationships());
//        System.out.println("orderBy : " + visitor.getOrderByColumns());
//
//        assertEquals(1, visitor.getTables().size());
//
//        assertEquals(3, visitor.getColumns().size());
//
//        assertTrue(visitor.getColumns().contains(new TableStat.Column("JWGZPT.A", "XM")));
    }
}
