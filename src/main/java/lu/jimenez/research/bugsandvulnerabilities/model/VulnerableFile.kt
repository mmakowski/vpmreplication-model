/////////////////////////////////////////////////////////////////////////////////////////
//                 University of Luxembourg  -
//                 Interdisciplinary center for Security and Trust (SnT)
//                 Copyright © 2016 University of Luxembourg, SnT
//
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 3 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//
//
//    Author: Matthieu Jimenez – SnT – matthieu.jimenez@uni.lu
//
//////////////////////////////////////////////////////////////////////////////////////////
package lu.jimenez.research.bugsandvulnerabilities.model



import lu.jimenez.research.bugsandvulnerabilities.model.internal.Document
import java.io.Serializable

/**
 * Vulnerable File Data class
 *
 * This class is representing a vulnerable file before and after its correction
 *
 * @property vulnerableFile the vulnerable *[file][Document]*
 * @property patchedFile the patched *[file][Document]*
 * @property fullCommitMessage content of the Commit message
 * @property origin cve or vulnerability keyword
 * @property cve CVE number
 * @property cwe CWE number
 *
 * @author Matthieu Jimenez
 */
data class VulnerableFile(val vulnerableFile: Document, val patchedFile: Document, val fullCommitMessage: String, val origin: Boolean, var cwe: String = "", var cve: String = "") : Serializable