/**
 * Copyright 2009 the original author or authors.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.javacrumbs.shedlock.test.support.jdbc;

import javax.sql.DataSource;

public interface DbConfig {
    void startDb();

    void shutdownDb();

    String getJdbcUrl();

    String getUsername();

    String getPassword();

    default String getCreateTableStatement() {
        return "CREATE TABLE shedlock(name VARCHAR(64) NOT NULL, lock_until TIMESTAMP  NOT NULL, locked_at TIMESTAMP  NOT NULL, locked_by VARCHAR(255) NOT NULL, PRIMARY KEY (name))";
    }

    String nowExpression();

    DataSource getDataSource();

    default String getR2dbcUrl() {
        return getJdbcUrl().replace("jdbc", "r2dbc");
    }
}
