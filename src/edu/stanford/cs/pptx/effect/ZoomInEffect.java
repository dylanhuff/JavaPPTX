/*
 * File: ZoomInEffect.java
 * -----------------------
 * This class implements the ZoomIn effect.
 */

package edu.stanford.cs.pptx.effect;

import edu.stanford.cs.pptx.util.PPOutputStream;

/**
 * This entrance effect causes the shape to grow from a point into its
 * final position.  The legal options are:
 *
 * <table border=0>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/onClick</code></td>
 *     <td>Effect takes place after a mouse click</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/afterPrev</code></td>
 *     <td>Effect takes place after the previous one</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/withPrev</code></td>
 *     <td>Effect takes place with the previous one</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/delay:</code><i>time</i></td>
 *     <td>Effect is delayed by <i>time</i> seconds</td></tr>
 * <tr><td style="padding-left:2em; width:10em;">
 *     <code>/duration:</code><i>time</i></td>
 *     <td>Effect lasts <i>time</i> seconds</td></tr>
 * </table>
 */

public class ZoomInEffect extends AnimationEffect {

   public ZoomInEffect() {
      super("ZoomIn");
   }

   public void preOptionHook() {
      setDirection("zoomIn");
      setDuration("veryFast");
   }

   @Override
   public String getPresetTag() {
      return "presetID='23' presetClass='entr' presetSubtype='16'";
   }

   @Override
   public void dumpBehavior(PPOutputStream os, String delayTag) {
      os.print("<p:set>");
      os.print("<p:cBhvr>");
      os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
               "dur='1' fill='hold'>");
      os.print("<p:stCondLst>");
      os.print("<p:cond " + delayTag + "/>");
      os.print("</p:stCondLst>");
      os.print("</p:cTn>");
      os.print("<p:tgtEl>");
      os.print("<p:spTgt spid='" + getShape().getShapeId() + "'/>");
      os.print("</p:tgtEl>");
      os.print("<p:attrNameLst>");
      os.print("<p:attrName>style.visibility</p:attrName>");
      os.print("</p:attrNameLst>");
      os.print("</p:cBhvr>");
      os.print("<p:to><p:strVal val='visible'/></p:to>");
      os.print("</p:set>");
      os.print("<p:anim calcmode='lin' valueType='num'>");
      os.print("<p:cBhvr>");
      os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
               getDurationTag() + " fill='hold'/>");
      os.print("<p:tgtEl>");
      os.print("<p:spTgt spid='" + getShape().getShapeId() + "'/>");
      os.print("</p:tgtEl>");
      os.print("<p:attrNameLst>");
      os.print("<p:attrName>ppt_w</p:attrName>");
      os.print("</p:attrNameLst>");
      os.print("</p:cBhvr>");
      os.print("<p:tavLst>");
      os.print("<p:tav tm='0'>");
      os.print("<p:val>");
      os.print("<p:fltVal val='0'/>");
      os.print("</p:val>");
      os.print("</p:tav>");
      os.print("<p:tav tm='100000'>");
      os.print("<p:val>");
      os.print("<p:strVal val='#ppt_w'/>");
      os.print("</p:val>");
      os.print("</p:tav>");
      os.print("</p:tavLst>");
      os.print("</p:anim>");
      os.print("<p:anim calcmode='lin' valueType='num'>");
      os.print("<p:cBhvr>");
      os.print("<p:cTn id='" + os.getNextSequenceId() + "' " +
               getDurationTag() + " fill='hold'/>");
      os.print("<p:tgtEl>");
      os.print("<p:spTgt spid='" + getShape().getShapeId() + "'/>");
      os.print("</p:tgtEl>");
      os.print("<p:attrNameLst>");
      os.print("<p:attrName>ppt_h</p:attrName>");
      os.print("</p:attrNameLst>");
      os.print("</p:cBhvr>");
      os.print("<p:tavLst>");
      os.print("<p:tav tm='0'>");
      os.print("<p:val>");
      os.print("<p:fltVal val='0'/>");
      os.print("</p:val>");
      os.print("</p:tav>");
      os.print("<p:tav tm='100000'>");
      os.print("<p:val>");
      os.print("<p:strVal val='#ppt_h'/>");
      os.print("</p:val>");
      os.print("</p:tav>");
      os.print("</p:tavLst>");
      os.print("</p:anim>");
   }

}
