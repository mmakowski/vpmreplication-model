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
 * Buggy File Data class
 *
 * This class is representing a file that was mentionned in commit that lead to a bug fixing in its 2 versions (Patched/ Not Patched)
 *
 * @property buggyFile the bugged *[file][Document]*
 * @property patchedFile the patched *[file][Document]*
 * @property bugzillaLink link to the bugzilla report
 * @property fullCommitMessage content of the Commit message
 *
 * @author Matthieu Jimenez
 */
data class BuggyFile(val buggyFile: Document, val patchedFile: Document, val bugzillaLink: String, val fullCommitMessage: String) : Serializable