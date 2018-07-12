/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.dbtest.engine.dcl;

import com.google.common.base.Strings;
import io.shardingsphere.dbtest.cases.assertion.dcl.DCLIntegrateTestCaseAssertion;
import io.shardingsphere.dbtest.engine.SingleIntegrateTest;
import io.shardingsphere.dbtest.env.DatabaseTypeEnvironment;
import io.shardingsphere.dbtest.env.EnvironmentPath;
import io.shardingsphere.dbtest.env.dataset.DataSetEnvironmentManager;
import io.shardingsphere.test.sql.SQLCaseType;
import org.junit.Before;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public abstract class BaseDCLIntegrateTest extends SingleIntegrateTest {
    
    private final DCLIntegrateTestCaseAssertion assertion;
    
    public BaseDCLIntegrateTest(final String sqlCaseId, final String path, final DCLIntegrateTestCaseAssertion assertion, final String shardingRuleType,
                                final DatabaseTypeEnvironment databaseTypeEnvironment, final SQLCaseType caseType) throws IOException, JAXBException, SQLException, ParseException {
        super(sqlCaseId, path, assertion, shardingRuleType, databaseTypeEnvironment, caseType);
        this.assertion = assertion;
    }
    
    @Before
    public void insertData() throws SQLException, ParseException, IOException, JAXBException {
        if (getDatabaseTypeEnvironment().isEnabled()) {
            new DataSetEnvironmentManager(EnvironmentPath.getDataInitializeResourceFile(getShardingRuleType()), getDataSourceMap()).initialize();
        }
    }
    
    protected void cleanEnvironment(final Connection connection) {
        if (!Strings.isNullOrEmpty(assertion.getCleanSQL())) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(assertion.getCleanSQL());
                // CHECKSTYLE: OFF
            } catch (final SQLException ignored) {
                // CHECKSTYLE: ON
            }
        }
    }
    
    protected void initEnvironment(final Connection connection) {
        if (!Strings.isNullOrEmpty(assertion.getInitSQL())) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(assertion.getInitSQL());
                // CHECKSTYLE: OFF
            } catch (final SQLException ignored) {
                // CHECKSTYLE: ON
            }
        }
    }
}
