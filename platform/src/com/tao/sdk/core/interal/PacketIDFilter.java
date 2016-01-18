/**
 * $RCSfile$
 * $Revision: 7071 $
 * $Date: 2007-02-11 16:59:05 -0800 (Sun, 11 Feb 2007) $
 *
 * Copyright 2003-2007 Jive Software.
 *
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
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
 */

package com.tao.sdk.core.interal;


import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.core.Packet;
import com.tao.sdk.util.StringUtil;


/**
 * Filters for packets with a particular packet ID.
 *
 * @author Matt Tucker
 */
public class PacketIDFilter implements PacketFilter {

    private String packetID;

    public PacketIDFilter(Packet packet) {
    	if(packet == null)
    		new RuntimeException("json object can not be null");
        this.packetID = packet.getPacketID();
    }

    public boolean accept(Packet packet) {
    	boolean result = false;
    	if(packet != null && StringUtil.equals(packet.getPacketID(), this.packetID)){
    		result = true;
    	}
        return result;
    }

    public String toString() {
        return "PacketCmdFilterby id: " + packetID;
    }

}
