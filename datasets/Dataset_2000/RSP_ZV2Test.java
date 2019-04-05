public class RSP_ZV2Test {
	@Test
	public void testGetQUERY_RESPONSE(){
				RSP_ZV2 msg = new RSP_ZV2();
		RSP_ZV2_QUERY_RESPONSE response = msg.getQUERY_RESPONSE();
		assertNotNull (response);
	}
	@Test
	public void testGetRSP_ZV2_QUERY_RESPONSEReps(){
		RSP_ZV2 msg = new RSP_ZV2();
		assertEquals(0 , msg.getQUERY_RESPONSEReps());
	}
	@Test
	public void testGetRSP_ZV2_QUERY_RESPONSERepsWithParams() throws Exception {
		RSP_ZV2 msg = new RSP_ZV2();
		RSP_ZV2_QUERY_RESPONSE response = msg.getQUERY_RESPONSE(0);
		assertNotNull (response);
		response = msg.getQUERY_RESPONSE(1);
		assertNotNull (response);
	}
}