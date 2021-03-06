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

package io.shardingsphere.jdbc.orchestration.spring;

import io.shardingsphere.core.jdbc.core.datasource.ShardingDataSource;
import io.shardingsphere.core.rule.ShardingRule;
import io.shardingsphere.jdbc.orchestration.internal.datasource.OrchestrationShardingDataSource;
import io.shardingsphere.jdbc.orchestration.spring.util.EmbedTestingServer;
import io.shardingsphere.jdbc.orchestration.spring.util.FieldValueUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.sql.DataSource;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations = "classpath:META-INF/rdb/shardingMasterSlaveNamespace.xml")
public class OrchestrationShardingMasterSlaveNamespaceTest extends AbstractJUnit4SpringContextTests {
    
    @BeforeClass
    public static void init() {
        EmbedTestingServer.start();
    }
    
    @Test
    public void assertDefaultShardingDataSource() {
        Map<String, DataSource> dataSourceMap = getDataSourceMap();
        assertNotNull(dataSourceMap.get("dbtbl_0_master"));
        assertNotNull(dataSourceMap.get("dbtbl_0_slave_0"));
        assertNotNull(dataSourceMap.get("dbtbl_0_slave_1"));
        assertNotNull(dataSourceMap.get("dbtbl_1_master"));
        assertNotNull(dataSourceMap.get("dbtbl_1_slave_0"));
        assertNotNull(dataSourceMap.get("dbtbl_1_slave_1"));
        ShardingRule shardingRule = getShardingRule();
        assertThat(shardingRule.getShardingDataSourceNames().getDefaultDataSourceName(), is("defaultMasterSlaveDataSource"));
        assertThat(shardingRule.getTableRules().size(), is(1));
        assertThat(shardingRule.getTableRules().iterator().next().getLogicTable(), is("t_order"));
    }
    
    @SuppressWarnings("unchecked")
    private Map<String, DataSource> getDataSourceMap() {
        OrchestrationShardingDataSource shardingDataSource = applicationContext.getBean("defaultShardingDataSource", OrchestrationShardingDataSource.class);
        ShardingDataSource dataSource = (ShardingDataSource) FieldValueUtil.getFieldValue(shardingDataSource, "dataSource");
        return dataSource.getDataSourceMap();
    }
    
    private ShardingRule getShardingRule() {
        OrchestrationShardingDataSource shardingDataSource = applicationContext.getBean("defaultShardingDataSource", OrchestrationShardingDataSource.class);
        ShardingDataSource dataSource = (ShardingDataSource) FieldValueUtil.getFieldValue(shardingDataSource, "dataSource");
        Object shardingContext = FieldValueUtil.getFieldValue(dataSource, "shardingContext");
        return (ShardingRule) FieldValueUtil.getFieldValue(shardingContext, "shardingRule");
    }
}
